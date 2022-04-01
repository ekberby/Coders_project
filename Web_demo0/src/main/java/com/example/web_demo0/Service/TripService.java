package com.example.web_demo0.Service;

import com.example.web_demo0.Model.Entity.Trip;
import com.example.web_demo0.Model.dto.TripDto;

import java.util.List;

public interface TripService {
    List<TripDto> getAll();

    void create(Trip trip);

    TripDto getById(String name);

    void deleteTripByID(String name);
}
