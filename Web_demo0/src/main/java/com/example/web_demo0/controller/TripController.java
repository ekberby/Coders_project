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

    @GetMapping("")
    public String showButtons(){
        return "main_page";
    }

    @GetMapping("/trips/new")
    public String createUserForm(Model model) {
        Trip trip = new Trip();
        model.addAttribute("trip", trip);
        return "";
    }

    @GetMapping("/trips/camp")
    public String showCamp(Model model){
        model.addAttribute("camps", tripService.getByType(TripType.KAMPING));
        return "camp";
    }

    @GetMapping("/trips/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model) {
        model.addAttribute("trip", tripService.getByID(id));
        return "edit_trip";
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

    @GetMapping("/trips/{id}")
    public String deleteUser(@PathVariable String id) {
        tripService.deleteTripByID(id);
        return "redirect:/trips/camp";
    }
}
