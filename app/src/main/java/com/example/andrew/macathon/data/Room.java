package com.example.andrew.macathon.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class Room {

    private String name, building;
    private boolean isOccupied;

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

    public boolean getOccupationState(){
        return isOccupied;
    }

    public void setOccupationState(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Room(String name, String building){
        this.name = name;
        this.building = building;
    }

    private List<Tuple> scheduledTimes = new ArrayList<Tuple>();

    public List<Tuple> getScheduledTimes(){
        return scheduledTimes;
    }

    public void addScheduleTimes(Tuple time){
        this.scheduledTimes.add(time);

    }
}
