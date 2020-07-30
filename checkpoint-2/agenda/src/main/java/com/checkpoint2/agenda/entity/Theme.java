package com.checkpoint2.agenda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<Event> Events;

    public Theme() {
    }

    public Theme(Long id, String name, List<Event> events) {
        this.id = id;
        this.name = name;
        Events = events;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Event> getEvents() { return Events; }
    public void setEvents(List<Event> events) { Events = events; }

}
