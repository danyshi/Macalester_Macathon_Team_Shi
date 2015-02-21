package com.example.andrew.macathon.data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class CampusCentre {

    private HashMap<Integer, List<Room>> availableRooms;
    private List<Room> roomsList = new ArrayList<Room>();

    public void generateRooms(){
        this.roomsList.add(new Room("CC 201", "Campus Centre"));
        this.roomsList.add(new Room("CC 202", "Campus Centre"));
        this.roomsList.add(new Room("CC 203", "Campus Centre"));
        this.roomsList.add(new Room("CC 204", "Campus Centre"));
        this.roomsList.add(new Room("CC 205", "Campus Centre"));
        this.roomsList.add(new Room("CC 206", "Campus Centre"));
        this.roomsList.add(new Room("CC 207", "Campus Centre"));
    }

    public void generateEmptyTable(){
        Integer i;
        for (i=0;i<2400;i+=50){
            availableRooms.put(i, null);
        }
    }

    public void generateSchedule(){
        ArrayList roomslist2 = new ArrayList();
        Room room1 = roomsList.get(1);
        roomslist2.add(room1);
        availableRooms.put(1000, roomslist2);
    }
}
