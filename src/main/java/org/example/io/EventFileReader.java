package org.example.io;

import org.example.model.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventFileReader {

    public ArrayList<Event> readFromResources(String resourceName) throws IOException {
        String json = JsonUtils.readResource(resourceName);
        List<Map<String, String>> objects = JsonUtils.parseObjectArray(json);
        ArrayList<Event> events = new ArrayList<>();

        for (Map<String, String> obj : objects) {
            int id = Integer.parseInt(obj.get("id"));
            int tributeId = Integer.parseInt(obj.get("tributeId"));
            String type = obj.get("type");
            int points = Integer.parseInt(obj.get("points"));
            int day = Integer.parseInt(obj.get("day"));

            events.add(new Event(id, tributeId, type, points, day));
        }

        return events;
    }
}
