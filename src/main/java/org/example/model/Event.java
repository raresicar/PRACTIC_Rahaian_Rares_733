package org.example.model;

public class Event {

    private final int id;
    private final int tributeId;
    private final String type;
    private final int points;
    private final int day;

    public Event(int id, int tributeId, String type, int points, int day) {
        this.id = id;
        this.tributeId = tributeId;
        this.type = type;
        this.points = points;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public int getTributeId() {
        return tributeId;
    }

    public String getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Event{" +
                id + " | " +
                "tributeId=" + tributeId + " | " +
                type + " | " +
                "points=" + points + " | " +
                "day=" + day +
                "}";
    }
}
