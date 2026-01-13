package org.example.io;

import org.example.model.Tribut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TributFileReader {

    public ArrayList<Tribut> readFromResources(String resourceName) throws IOException {
        String json = JsonUtils.readResource(resourceName);
        List<Map<String, String>> objects = JsonUtils.parseObjectArray(json);
        ArrayList<Tribut> tributes = new ArrayList<>();

        for (Map<String, String> obj : objects) {
            int id = Integer.parseInt(obj.get("id"));
            String name = obj.get("name");
            int district = Integer.parseInt(obj.get("district"));
            String status = obj.get("status");
            int skillLevel = Integer.parseInt(obj.get("skillLevel"));

            tributes.add(new Tribut(id, name, district, status, skillLevel));
        }

        return tributes;
    }
}
