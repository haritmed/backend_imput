package com.example.employeeimput.controllers;

import com.example.employeeimput.entities.Event;
import com.example.employeeimput.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping("/{date}")
    public List<Event> getEventsByDate(@PathVariable String date) {
        LocalDate eventDate = LocalDate.parse(date);
        return eventRepository.findByEventDate(eventDate);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}

