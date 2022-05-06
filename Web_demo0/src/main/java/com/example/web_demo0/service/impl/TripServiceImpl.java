package com.example.web_demo0.service.impl;

import com.example.web_demo0.model.entity.Trip;
import com.example.web_demo0.model.dto.TripDto;
import com.example.web_demo0.model.enums.TripType;
import com.example.web_demo0.repository.TripRepository;
import com.example.web_demo0.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TripServiceImpl  implements TripService {
    private final TripRepository tripRepository;

    @Override
    public List<TripDto> getAll() {
        return tripRepository.findAll().stream().map(this::mapToTripDto).collect(Collectors.toList());
    }

    @Override
    public void create(Trip trip) {
        tripRepository.save(trip);
    }



    @Override
    public List<Trip> getByType(TripType tripType) {
        return tripRepository.findByTripType(tripType);
    }

    @Override
    public void deleteTripByID(String name) {
        tripRepository.deleteById(name);
    }

    @Override
    public Trip getByID(String name) {
        return tripRepository.findByName(name);
    }


    private TripDto mapToTripDto(Trip trip){
        return TripDto.builder().tripType(trip.getTripType()).address(trip.getAddress()).name(trip.getName())
                .numberOfDays(trip.getNumberOfDays()).price(trip.getPrice()).build();
    }
}
