package com.MainApp.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MainApp.SpringMVC.domain.AppUser;

@Controller
public class DashBoardMainController {

	@GetMapping("/header")
    public String heaer(Model model) {
        model.addAttribute("user", new AppUser());
        return "mainapp/header";
    }
	@GetMapping("/asidenav")
    public String asideNav(Model model) {
        model.addAttribute("user", new AppUser());
        return "mainapp/asideNav";
    }
	
	@GetMapping("/footer")
    public String footer(Model model) {
        model.addAttribute("user", new AppUser());
        return "mainapp/footer";
    }
}
