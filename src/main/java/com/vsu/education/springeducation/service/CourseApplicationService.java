package com.vsu.education.springeducation.service;

import com.google.common.collect.Lists;
import com.vsu.education.springeducation.data.model.*;
import com.vsu.education.springeducation.data.storage.CourseApplicationStorage;
import com.vsu.education.springeducation.data.storage.PaymentsStorage;
import com.vsu.education.springeducation.data.storage.StudentStorage;
import com.vsu.education.springeducation.data.storage.StudentsGroupStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// @Controller == @service ~= @Repository == @Component
@Service
public class CourseApplicationService {
    private final CourseApplicationStorage courseApplicationStorage;
    private final StudentStorage studentStorage;
    private final StudentsGroupStorage studentsGroupStorage;
    private final PaymentsStorage paymentsStorage;

    public CourseApplicationService(CourseApplicationStorage courseApplicationStorage, StudentStorage studentStorage, StudentsGroupStorage studentsGroupStorage, PaymentsStorage paymentsStorage) {
        this.courseApplicationStorage = courseApplicationStorage;
        this.studentStorage = studentStorage;
        this.studentsGroupStorage = studentsGroupStorage;
        this.paymentsStorage = paymentsStorage;
    }

    public void addCourseApplication(CourseApplication courseApplication) {
        courseApplicationStorage.addCourseApplication(courseApplication);
    }

    public List<CourseApplication> getCourseApplications() {
        return courseApplicationStorage.getAllCourseApplications();
    }

    public void endApplications() {
        var applications = courseApplicationStorage.getAllCourseApplications();

        for (CourseApplication application : applications) {
            var student = application.getStudent();
            student.setCourse(application.getCourse()); // TODO Перенести это в место, где создаётся CourseApplication
            studentStorage.addStudent(student);
        }

        var students = studentStorage.getAllStudent();

        var groupedStudents = students.stream().collect((Collectors.groupingBy(Student::getCourse)));

        for (Map.Entry<Course, List<Student>> entry : groupedStudents.entrySet()) {
            var courseStudents = entry.getValue();

            for (List<Student> groupStudents : Lists.partition(courseStudents, 7)) {
                studentsGroupStorage.addStudentsGroup(new StudentsGroup(1, entry.getKey(), groupStudents));
            }
        }

        for (Student student : students) {
            var currentCourseTime = student.getCourseTime();
            student.setCourseTime(currentCourseTime + 2);
            paymentsStorage.addPayments(
                    new Payments(1, student, student.getCourse())
            );
        }
    }

    // Добавляю студентов - отдбельно в запросу к серверу
    // Отправляю от них аппликэйшн
    // Получаю всех студентов
    // Отфильтровываю тех, кто закончил обучение
    // Группирую по курсу
    // Собираю в группы
    // Проверяю, может ли перейти на новый курс. Если может - перевожу на новый
    // Провожу оплату курсов
}
