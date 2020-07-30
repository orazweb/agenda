package com.checkpoint2.agenda.controller;

import com.checkpoint2.agenda.entity.Organizer;
import com.checkpoint2.agenda.entity.Theme;
import com.checkpoint2.agenda.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class OrganizerController {
    @Autowired
    private OrganizerRepository repository;

    // DISPLAY ONE ORGANIZER
    @GetMapping("/organizer")
    public String getOrganizer(Model model,
                           @RequestParam(required = false) Long id) {

        Organizer organizer = new Organizer();

        if (id != null) {
            Optional<Organizer> optionalOrganizer = repository.findById(id);
            if (optionalOrganizer.isPresent()) {
                organizer = optionalOrganizer.get();
            }
        }
        model.addAttribute("organizer", organizer);
        return "organizer";
    }

    // DISPLAY ALL ORGANIZER
    @GetMapping("/organizers")
    public String getAll(Model model) {
        model.addAttribute("organizers", repository.findAll());
        return "organizers";
    }

    // CREATE / UPDATE ORGANIZER
    @PostMapping("/organizer")
    public String editOrganizer(@ModelAttribute Organizer organizer) {
        repository.save(organizer);
        return "redirect:/organizers";
    }

    // DELETE ORGANIZER
    @GetMapping("/organizer/delete")
    public String deleteOrganizer(@RequestParam Long id) {

        repository.deleteById(id);

        return "redirect:/organizers";
    }
}
