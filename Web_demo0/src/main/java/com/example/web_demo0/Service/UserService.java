package com.example.web_demo0.Service;

import com.example.web_demo0.Model.Entity.User;
import com.example.web_demo0.Model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    void create(User user);

    UserDto getById(String username);

    void deleteUserById(String username);
}
