package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.User;
import com.example.web_demo0.model.enums.Role;
import com.example.web_demo0.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @ModelAttribute("user")
    public User userRegistrationDto() {
        return new User();
    }

    @GetMapping()
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping()
    public String registerUserAccount(@ModelAttribute("user") User user){
        user.setRole(Role.USER);
        userService.create(user);
        return "redirect:/registration?success";
    }
}
