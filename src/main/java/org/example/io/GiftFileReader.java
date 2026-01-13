package org.example.io;

import org.example.model.Gift;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GiftFileReader {

    public ArrayList<Gift> readFromResources(String resourceName) throws IOException {
        String json = JsonUtils.readResource(resourceName);
        List<Map<String, String>> objects = JsonUtils.parseObjectArray(json);
        ArrayList<Gift> gifts = new ArrayList<>();

        for (Map<String, String> obj : objects) {
            int id = Integer.parseInt(obj.get("id"));
            int tributeId = Integer.parseInt(obj.get("tributeId"));
            String itemName = obj.get("itemName");
            int value = Integer.parseInt(obj.get("value"));
            int day = Integer.parseInt(obj.get("day"));

            gifts.add(new Gift(id, tributeId, itemName, value, day));
        }

        return gifts;
    }
}
