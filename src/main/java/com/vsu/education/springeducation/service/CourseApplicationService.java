package com.vsu.education.springeducation.service;

import com.google.common.collect.Lists;
import com.vsu.education.springeducation.data.entity.*;
import com.vsu.education.springeducation.data.storage.*;
import com.vsu.education.springeducation.data.domain.CourseApplication;
import com.vsu.education.springeducation.data.domain.Student;
import com.vsu.education.springeducation.data.domain.StudentsGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// @Controller == @service ~= @Repository == @Component
@Service
public class CourseApplicationService {
    private final CourseApplicationStorage courseApplicationStorage;
    private final StudentStorage studentStorage;
    private final StudentService studentService;
    private final StudentsGroupStorage studentsGroupStorage;
    private final PaymentsStorage paymentsStorage;
    private final CourseStorage courseStorage;

    public CourseApplicationService(
            CourseApplicationStorage courseApplicationStorage,
            StudentStorage studentStorage,
            StudentsGroupStorage studentsGroupStorage,
            PaymentsStorage paymentsStorage,
            CourseStorage courseStorage,
            StudentService studentService
    ) {
        this.courseApplicationStorage = courseApplicationStorage;
        this.studentStorage = studentStorage;
        this.studentsGroupStorage = studentsGroupStorage;
        this.paymentsStorage = paymentsStorage;
        this.courseStorage = courseStorage;
        this.studentService = studentService;
    }

    public void addCourseApplication(CourseApplication courseApplicationEntity) {
        courseApplicationStorage.addCourseApplication(courseApplicationEntity);
    }

    public List<CourseApplication> getCourseApplications() {
        var courseApplications = courseApplicationStorage.getAllCourseApplications();
        return courseApplications.stream().map(application -> {
            var studentWithCourse = studentService.getStudentWithCourseById(application.getStudent_id(), application.getCourse_id());
            var course = courseStorage.getCourseById(application.getCourse_id());
            return new CourseApplication(
                    application.getId(),
                    studentWithCourse,
                    course
            );
        }).toList();
    }

    public void endApplications() {
        var applications = getCourseApplications();

        for (CourseApplication application : applications) {
            var student = application.getStudent();
            var course = application.getCourseEntity();
            student.setCourseEntity(application.getCourseEntity()); // TODO Перенести это в место, где создаётся CourseApplication
            studentStorage.updateStudentCourse(student, course);
        }

        var students = studentStorage.getAllStudents();
        var studentsWithCourse = students.stream().map(student -> {
                    CourseEntity course = null;
                    if (student.getCourseId() != 0) {
                        course = courseStorage.getCourseById(student.getCourseId());
                    }
                    return new Student(
                            student.getId(),
                            student.getName(),
                            student.getSurname(),
                            student.getPatronymic(),
                            student.getPhoneNumber(),
                            course,
                            student.getCourseTime()
                    );
                }
        ).toList();

        var groupedStudents = studentsWithCourse.stream()
                .filter(student -> student.getCourseEntity() != null)
                .peek(student -> {
                    if (student.finishedCourse()) {
                        student.setCourseEntity(null);
                    }
                    if (student.canGoToNextLevel()) {
                        student.goToNextLevel();
                    }
                })
                .collect((Collectors.groupingBy(Student::getCourseEntity)));

        for (Map.Entry<CourseEntity, List<Student>> entry : groupedStudents.entrySet()) {
            if (entry.getKey() == null) continue;

            var courseStudents = entry.getValue();

            for (List<Student> groupStudentEntities : Lists.partition(courseStudents, 7)) {
                var studentsGroup = new StudentsGroup(1, groupStudentEntities);
                studentsGroupStorage.addStudentsGroup(new StudentsGroupEntity(1, studentsGroup.getStudentsIds()));
            }
        }

        for (Student student : studentsWithCourse) {
            if (student.getCourseEntity() != null) {
                var currentCourseTime = student.getCourseTime();
                student.setCourseTime(currentCourseTime + 2);
                paymentsStorage.addPayments(
                        new PaymentEntity(1, student.getId(), student.getCourseEntity().getId(), student.getCourseEntity().getPrice())
                );
                studentStorage.updateStudentCourseTime(student);
            }
        }
    }

    // Добавляю студентов - отдбельно в запросу к серверу
    // Отправляю от них заявку
    // Меняю курс студентам на указанный в заявке
    // + Получаю всех студентов
    // + Отфильтровываю тех, кто закончил обучение и не подал заявку
    // + Группирую по курсу
    // + Собираю в группы
    // + Проверяю, может ли перейти на новый курс. Если может - перевожу на новый
    // + Провожу оплату курсов
}
