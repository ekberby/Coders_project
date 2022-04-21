package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.Trip;
import com.example.web_demo0.model.dto.TripDto;
import com.example.web_demo0.service.impl.TripServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("trips")
@CrossOrigin
public class TripController {
    private final TripServiceImpl tripService;
    @PostMapping
    public void save(@RequestBody Trip trip){
        tripService.create(trip);
    }

    @GetMapping
    public List<TripDto> get(){
        return tripService.getAll();
    }

    @DeleteMapping
    public void delete(@RequestParam String name){
        tripService.deleteTripByID(name);
    }
}
