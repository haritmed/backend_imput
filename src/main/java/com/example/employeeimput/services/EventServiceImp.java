package com.example.employeeimput.services;

import com.example.employeeimput.entities.Event;
import com.example.employeeimput.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EventServiceImp implements EventService{
    @Autowired
    private EventRepository eventRepository;
    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public void deleteEventById(Long id) {

    }

    @Override
    public void deleteAllEvent() {

    }

    @Override
    public Event getEventById(Long id) {
        return null;
    }

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Page<Event> getAllEventByPage(int page, int size) {
        return null;
    }
}
