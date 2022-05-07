package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.User;
import com.example.web_demo0.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String showHome(){
        return "main_page";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @ModelAttribute("user")
    public User userRegistrationDto() {
        return new User();
    }
}
