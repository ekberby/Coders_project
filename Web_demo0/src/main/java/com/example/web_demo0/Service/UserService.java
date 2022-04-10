package com.example.web_demo0.service;

import com.example.web_demo0.model.entity.User;
import com.example.web_demo0.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    void create(User user);

    UserDto getById(String username);

    void deleteUserById(String username);
}
