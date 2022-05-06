package com.example.web_demo0.repository;

import com.example.web_demo0.model.entity.Trip;
import com.example.web_demo0.model.enums.TripType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TripRepository extends CrudRepository<Trip, String> {
    List<Trip> findAll();

    @Override
    void deleteById(String s);

    List<Trip> findByTripType(TripType tripType);

    Trip findByName(String name);
}
