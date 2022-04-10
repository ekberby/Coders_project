package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.User;
import com.example.web_demo0.model.dto.UserDto;
import com.example.web_demo0.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private UserServiceImpl userService;

    @PostMapping
    public void save(@RequestBody User user){
        System.out.println("Hello");
        userService.create(user);
    }

    @GetMapping
    public List<UserDto> get(){
        return userService.getAll();
    }

    @DeleteMapping
    public void delete(@RequestParam String username){
        userService.deleteUserById(username);
    }
}
