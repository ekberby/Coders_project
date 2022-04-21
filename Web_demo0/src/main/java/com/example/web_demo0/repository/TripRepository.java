package com.example.web_demo0.repository;

import com.example.web_demo0.model.entity.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, String> {
    List<Trip> findAll();

    @Override
    void deleteById(String s);
}
