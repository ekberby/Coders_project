package com.example.web_demo0.service;

import com.example.web_demo0.model.entity.Trip;
import com.example.web_demo0.model.dto.TripDto;
import com.example.web_demo0.model.enums.TripType;

import java.util.List;

public interface TripService {
    List<TripDto> getAll();

    void create(Trip trip);

    List<Trip> getByType(TripType tripType);

    void deleteTripByID(String name);

    Trip getByID(String name);
}
