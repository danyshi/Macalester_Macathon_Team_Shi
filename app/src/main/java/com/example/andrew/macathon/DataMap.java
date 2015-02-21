package com.example.andrew.macathon;

import com.example.andrew.macathon.data.*;
import com.example.andrew.macathon.data.Room;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class DataMap {

    private HashMap<Integer, List<Room>> availableRooms;
    public void getData(){
        CampusCentre CC = new CampusCentre();
        availableRooms = CC.getSchedule();
    }

}
