package com.example.web_demo0.Repository;

import com.example.web_demo0.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();

    @Override
    void deleteById(String s);
}
