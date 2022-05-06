package com.example.web_demo0.repository;

import com.example.web_demo0.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();

    User findByUsername(String username);
    @Override
    void deleteById(String s);
}
