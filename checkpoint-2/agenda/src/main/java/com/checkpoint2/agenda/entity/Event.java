package com.checkpoint2.agenda.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_event")
    private Date dateEvent;
    private String description;
    private float price;
    private String imagePath;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;

    public Event() { }

    public Event(Long id, String name, Date dateEvent, String description, float price, String imagePath, Theme theme, Location location, Organizer organizer) {
        this.id = id;
        this.name = name;
        this.dateEvent = dateEvent;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.theme = theme;
        this.location = location;
        this.organizer = organizer;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDateEvent() { return dateEvent; }
    public void setDateEvent(Date dateEvent) { this.dateEvent = dateEvent; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public Theme getTheme() { return theme; }
    public void setTheme(Theme theme) { this.theme = theme; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public Organizer getOrganizer() { return organizer; }
    public void setOrganizer(Organizer organizer) { this.organizer = organizer; }
}
