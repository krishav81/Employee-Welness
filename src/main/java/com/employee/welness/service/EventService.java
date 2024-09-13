package com.employee.welness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.welness.models.Event;
import com.employee.welness.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Optional<Event> existingEvent = eventRepository.findById(id);
        if (existingEvent.isPresent()) {
            Event event = existingEvent.get();
            event.setEventName(updatedEvent.getEventName());
            event.setDescription(updatedEvent.getDescription());
            event.setEventDate(updatedEvent.getEventDate());
            event.setLocation(updatedEvent.getLocation());
            event.setStatus(updatedEvent.getStatus());
            return eventRepository.save(event);
        } else {
            return null; // Handle not found case
        }
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
