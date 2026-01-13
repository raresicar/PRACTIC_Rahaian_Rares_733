package org.example.service;

import org.example.model.Event;

import java.util.List;

public class EventStats {
    public void printFirstFiveComputedPoints(List<Event> events) {
        events.stream()
                .limit(5)
                .forEach(event -> System.out.println("Event " + event.getId()
                        + " -> rawPoints=" + event.getPoints()
                        + " -> computedPoints=" + event.getComputedPoints()));
    }
}
