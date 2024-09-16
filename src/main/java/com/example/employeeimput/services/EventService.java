package com.example.employeeimput.services;
import com.example.employeeimput.entities.Event;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event); //"Create" pour créer un nouveau client s'il nexiste pas id
    Event updateEvent(Event event);//"Update"
    void deleteEventById(Long id);//"Delete by id"
    void deleteAllEvent();//"Delete All"
    Event getEventById(Long id); //"Read by id"
    List<Event> getAllEvent();
    Page<Event> getAllEventByPage(int page, int size);
}
