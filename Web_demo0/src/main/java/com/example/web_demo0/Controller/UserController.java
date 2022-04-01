package com.example.web_demo0.Controller;

import com.example.web_demo0.Model.Entity.User;
import com.example.web_demo0.Model.dto.UserDto;
import com.example.web_demo0.Service.Impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private UserServiceImpl userService;

    @PostMapping
    public void save(@RequestBody User user){
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
