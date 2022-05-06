package com.example.web_demo0.controller;
import com.example.web_demo0.model.entity.User;
import com.example.web_demo0.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;

@Transactional
@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // handler method to handle list students and return mode and view
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model) {

        // create student object to hold student form data
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";

    }


    @PostMapping("/users")
    public String saveUser(@ModelAttribute("student") User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable String id,
                             @ModelAttribute("user") User user,
                             Model model) {

        // get student from database by id
        User existingUser = userService.getUserById(id);
        existingUser.setUsername(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        existingUser.setGender(user.getGender());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setRole(user.getRole());
        // save updated student object
        userService.create(existingUser);
        return "redirect:/users";
    }

    // handler method to handle delete student request

    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
