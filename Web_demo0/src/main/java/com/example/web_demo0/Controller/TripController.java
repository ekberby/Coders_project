package com.example.web_demo0.Controller;

import com.example.web_demo0.Model.Entity.Trip;
import com.example.web_demo0.Model.dto.TripDto;
import com.example.web_demo0.Service.Impl.TripServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("trips")
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
