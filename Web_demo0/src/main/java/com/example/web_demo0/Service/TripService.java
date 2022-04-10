package com.example.web_demo0.service;

import com.example.web_demo0.model.entity.Trip;
import com.example.web_demo0.model.dto.TripDto;

import java.util.List;

public interface TripService {
    List<TripDto> getAll();

    void create(Trip trip);

    TripDto getById(String name);

    void deleteTripByID(String name);
}
