package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.Trip;
import com.example.web_demo0.model.enums.TripType;
import com.example.web_demo0.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@Controller
@Transactional
@AllArgsConstructor
public class TripController {

    private final TripService tripService;


    @PostMapping("/trips")
    public String saveUser(@ModelAttribute("trip") Trip trip) {
        tripService.create(trip);
        return "redirect:/trips/camp";
    }

    @GetMapping("/trips/camp")
    public String showCamp(Model model){
        model.addAttribute("camps", tripService.getByType(TripType.CAMPING));
        return "camp";
    }

    @GetMapping("/trips/exc")
    public String showEks(Model model){
        model.addAttribute("excs", tripService.getByType(TripType.EXCURSION));
        return "excursion";
    }

    @GetMapping("/trips/tra")
    public String showSey(Model model){
        model.addAttribute("tras", tripService.getByType(TripType.TRAVEL));
        return "travel";
    }

    @GetMapping("/trips/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model) {
        model.addAttribute("trip", tripService.getByID(id));
        return "edit_trip";
    }

    @GetMapping("/trips/new")
    public String createTripForm(Model model) {
        Trip trip = new Trip();
        model.addAttribute("trip", trip);
        return "create_trip";

    }

    @PostMapping("/trips/{id}")
    public String updateUser(@PathVariable String id,
                             @ModelAttribute("trip") Trip trip,
                             Model model) {

        Trip existingTrip = tripService.getByID(id);
        existingTrip.setName(id);
        existingTrip.setTripType(trip.getTripType());
        existingTrip.setAddress(trip.getAddress());
        existingTrip.setUserList(trip.getUserList());
        existingTrip.setPrice(trip.getPrice());
        existingTrip.setNumberOfDays(trip.getNumberOfDays());

        tripService.create(existingTrip);
        return "redirect:/";
    }

    @GetMapping("/trips/delete/{id}")
    public String deleteTrip(@PathVariable String id){
        tripService.deleteTripByID(id);
        return "camp";
    }
}
