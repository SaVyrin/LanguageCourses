package com.vsu.education.springeducation.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome(@RequestParam(name = "name", required = false, defaultValue = "VSU") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
}