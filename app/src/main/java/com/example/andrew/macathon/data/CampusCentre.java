package com.example.andrew.macathon.data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ArrayList roomslist2 = new ArrayList();
        roomslist2.add(roomsList.get(1));
        roomslist2.add(roomsList.get(2));
        roomslist2.add(roomsList.get(3));
        roomslist2.add(roomsList.get(4));
        availableRooms.put(1000, roomslist2);
    }

    public void addEvent(Room room, Tuple time){
        Integer startTime = time.getStartTime();
        Integer endTime = time.getEndTime();
        for (Integer i=startTime;i<endTime;i+=50){
            List<Room> roomsList = availableRooms.get(i);
            if (roomsList==null){
                roomsList = new ArrayList<Room>();
            }
            roomsList.add(room);
            availableRooms.put(i, roomsList);
        }
    }
}
