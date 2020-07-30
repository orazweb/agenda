package com.checkpoint2.agenda.controller;

import com.checkpoint2.agenda.entity.Event;
import com.checkpoint2.agenda.entity.Organizer;
import com.checkpoint2.agenda.entity.Theme;
import com.checkpoint2.agenda.repository.EventRepository;

import com.checkpoint2.agenda.repository.LocationRepository;
import com.checkpoint2.agenda.repository.OrganizerRepository;
import com.checkpoint2.agenda.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class EventController {
    @Autowired
    private EventRepository repository;
    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private OrganizerRepository organizerRepository;

    // DISPLAY ONE EVENT
    @GetMapping("/event")
    public String getEvent(Model model,
                           @RequestParam(required = false) Long id) {

        Event event = new Event();
        Theme theme = new Theme();
        if (id != null) {
            Optional<Event> optionalEvent = repository.findById(id);
            if (optionalEvent.isPresent()) {
                event = optionalEvent.get();
            }
        }

        model.addAttribute("event", event);
        model.addAttribute("themes", themeRepository.findAll());
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("organizers", organizerRepository.findAll());

        return "event";
    }

    // DISPLAY ALL EVENTS
    @GetMapping("/events")
    public String getAll(Model model) {
        model.addAttribute("events", repository.findAll());
        return "events";
    }

    // CREATE / UPDATE EVENT
    @PostMapping("/event")
    public String editEvent(@ModelAttribute Event event) {
        repository.save(event);
        return "redirect:/events";
    }

    // DELETE EVENT
    @GetMapping("/event/delete")
    public String deleteEvent(@RequestParam Long id) {

        repository.deleteById(id);

        return "redirect:/events";
    }
}
