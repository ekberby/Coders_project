package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.Trip;
import com.example.web_demo0.Model.dto.TripDto;
import com.example.web_demo0.Repository.TripRepository;
import com.example.web_demo0.Service.TripService;
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
        return tripRepository.findAll().stream().map(trip -> mapToTripDto(trip)).collect(Collectors.toList());
    }

    @Override
    public void create(Trip trip) {
        tripRepository.save(trip);
    }



    @Override
    public TripDto getById(String name) {
        return tripRepository.findById(name).map(trip -> mapToTripDto(trip)).get();
    }

    @Override
    public void deleteTripByID(String name) {
        tripRepository.deleteById(name);
    }


    private TripDto mapToTripDto(Trip trip){
        return TripDto.builder().tripType(trip.getTripType()).address(trip.getAddress()).name(trip.getName())
                .numberOfDays(trip.getNumberOfDays()).price(trip.getPrice()).build();
    }
}
