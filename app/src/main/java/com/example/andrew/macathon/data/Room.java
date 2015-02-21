package com.example.andrew.macathon.data;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class Room {

    private String name, building;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room(String name, String building){
        this.name = name;
        this.building = building;
    }
}
