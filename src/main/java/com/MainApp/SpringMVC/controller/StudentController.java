package com.MainApp.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MainApp.JPALearn.Entities.Student;

@Controller
public class StudentController {
	@GetMapping("/addstudent")
    public String addstudent(Model model) {
        model.addAttribute("student", new Student());
        return "mainapp/Student/addStudent";
    }
}
