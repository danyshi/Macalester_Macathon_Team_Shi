package com.example.andrew.macathon.data;
import java.util.ArrayList;
import java.util.Collection;
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

    public HashMap<Integer, List<Room>> getSchedule(){
        return availableRooms;
    }

    public void generateSchedule(){
        Room room1 = roomsList.get(0);
        room1.addEvent(new Event(1000,1400, "Macathon Meeting"));
        room1.addEvent(new Event(1600,1800, "We have this space just because we can"));
        room1.addEvent(new Event(2200,2300, "Late night homework parties woo!"));

        Room room2 = roomsList.get(1);
        room2.addEvent(new Event(1900,2000, "Investment Group meeting"));
        room2.addEvent(new Event(2000,2100, "Entrepreneurship club"));
        room2.addEvent(new Event(1750,1850, "Singing in the CC"));

        Room room3 = roomsList.get(4);
        room3.addEvent(new Event(1900,2000, "Mac PandA"));
        room3.addEvent(new Event(2000,2100, "Mac Sudo"));
        room3.addEvent(new Event(1750,1850, "MCSG"));

        addRoom(room1);
        addRoom(room2);
        addRoom(room3);
    }

    public void addRoom(Room room){
        ArrayList<Event> scheduledEvents = room.getScheduledEvents();
        for (Event event : scheduledEvents){
            Integer startTime = event.getStartTime();
            Integer endTime = event.getEndTime();
            for (Integer i = startTime; i < endTime; i += 50) {
                List<Room> roomsList = availableRooms.get(i);
                if (roomsList == null) {
                    roomsList = new ArrayList<Room>();
                }
                roomsList.add(room);
                availableRooms.put(i, roomsList);
            }
        }
    }
}
