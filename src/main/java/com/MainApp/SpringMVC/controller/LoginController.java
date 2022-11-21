package com.MainApp.SpringMVC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MainApp.SpringMVC.domain.AppUser;

@Controller
public class LoginController {
    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String index(Model model) {
    	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
    	if(!(auth instanceof AnonymousAuthenticationToken)) {
    		model.addAttribute("authorities",auth.getAuthorities());
    		model.addAttribute("credentials",auth.getCredentials());
    		model.addAttribute("details",auth.getDetails());
    		model.addAttribute("principal",auth.getPrincipal());
    		model.addAttribute("class",auth.getClass());
    		model.addAttribute("name",auth.getName());
    		//return "mainapp/index";
    		return "welcome";
    	}
        return "loginfolder/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new AppUser());
        return "loginfolder/login";
    }

    //access only to admin
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/home")
    public String adminLandingPage() {
        log.info("Accessing admin page");
        return "loginfolder/admin"; //this name should match to admin.html inside templates folder
    }


    //access only for user
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/user/home")
    public String userLandingPage() {
        log.info("Accessing user page");
        return "loginfolder/user"; //this name should match to user.html inside templates folder
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("user", new AppUser());
        return "mainapp/home";
    }

}