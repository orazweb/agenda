package com.checkpoint2.agenda.controller;

import com.checkpoint2.agenda.entity.Location;
import com.checkpoint2.agenda.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LocationController {
    @Autowired
    private LocationRepository repository;

    // DISPLAY ONE LOCATION
    @GetMapping("/location")
    public String getLocation(Model model,
                           @RequestParam(required = false) Long id) {

        Location location = new Location();

        if (id != null) {
            Optional<Location> optionalLocation = repository.findById(id);
            if (optionalLocation.isPresent()) {
                location = optionalLocation.get();
            }
        }
        model.addAttribute("location", location);
        return "location";
    }

    // DISPLAY ALL LOCATIONS
    @GetMapping("/locations")
    public String getAll(Model model) {
        model.addAttribute("locations", repository.findAll());
        return "locations";
    }

    // CREATE / UPDATE LOCATION
    @PostMapping("/location")
    public String editLocation(@ModelAttribute Location location) {
        repository.save(location);
        return "redirect:/locations";
    }

    // DELETE LOCATION
    @GetMapping("/location/delete")
    public String deleteLocation(@RequestParam Long id) {

        repository.deleteById(id);

        return "redirect:/locations";
    }
}
