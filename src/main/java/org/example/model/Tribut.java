package org.example.model;



public class Tribut {

    private final int id;
    private final String name;
    private final int district;
    private final String status;
    private final int skillLevel;

    public Tribut(int id, String name, int district, String status, int skillLevel) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.status = status;
        this.skillLevel = skillLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDistrict() {
        return district;
    }

    public String getStatus() {
        return status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        return  id + " | " +
                name + " | " +
                "D" + district + " | " +
                status + " | " +
                "skill=" + skillLevel;
    }
}

