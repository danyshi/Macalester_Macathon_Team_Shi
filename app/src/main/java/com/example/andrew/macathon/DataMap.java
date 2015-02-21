package com.example.andrew.macathon;

import android.util.Log;

import com.example.andrew.macathon.data.*;
import com.example.andrew.macathon.data.Room;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class DataMap {

    private HashMap<Integer, ArrayList<Room>> schedule;
    private  CampusCentre cc;

    public DataMap() {
        Log.d("Data map: ", "Generating");
        cc = new CampusCentre();
        cc.generateRooms();
        Log.d("Data map: ", "Scheduling");
        cc.generateSchedule();
        schedule = cc.getSchedule();
        Log.d("Data map: ", schedule.toString());
    }

    public ArrayList<Room> getFreeRooms(){
        Integer time = getCurrentTime();
        Set<Room> symmetricDiff = new HashSet<Room>(cc.getAllRooms());
        HashSet<Room> unavailableRooms = new HashSet<Room>(schedule.get(time));
        symmetricDiff.addAll(unavailableRooms);
        Set<Room> tmp = new HashSet<Room>(cc.getAllRooms());
        tmp.retainAll(unavailableRooms);
        symmetricDiff.removeAll(tmp);
        return new ArrayList<Room>(symmetricDiff);
    }

    public ArrayList<Room> getBusyRooms(){
//        Log.d("Total time: ", schedule.get(totalTime).toString());
        return schedule.get(getCurrentTime());
    }

    public int getCurrentTime(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int totalTime = (hour * 100) + 50 * (minute/30);
        return totalTime;
    }
    private HashMap<Integer, ArrayList<Room>> availableRooms;

    public List<Room> getData(){
        CampusCentre CC = new CampusCentre();
        availableRooms = CC.getSchedule();
        return CC.getRoomsList();
    }
}
