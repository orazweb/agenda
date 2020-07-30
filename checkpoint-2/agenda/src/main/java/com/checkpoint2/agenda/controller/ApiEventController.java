package com.checkpoint2.agenda.controller;

import com.checkpoint2.agenda.entity.Event;
import com.checkpoint2.agenda.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApiEventController {

    @Autowired
    private EventRepository repository;

    @GetMapping("/api/events")
    @ResponseBody
    List<Event> getAllEvents() {
        return repository.findAll();
    }
}
