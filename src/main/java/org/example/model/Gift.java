package org.example.model;

public class Gift {

    private final int id;
    private final int tributeId;
    private final String itemName;
    private final int value;
    private final int day;

    public Gift(int id, int tributeId, String itemName, int value, int day) {
        this.id = id;
        this.tributeId = tributeId;
        this.itemName = itemName;
        this.value = value;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public int getTributeId() {
        return tributeId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getValue() {
        return value;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Gift{" +
                id + " | " +
                "tributeId=" + tributeId + " | " +
                itemName + " | " +
                "value=" + value + " | " +
                "day=" + day +
                "}";
    }
}
