package com.example.andrew.macathon;

import android.util.Log;

import com.example.andrew.macathon.data.*;
import com.example.andrew.macathon.data.Room;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Asra Nizami on 2/20/2015.
 */
public class DataMap {

    private HashMap<Integer, ArrayList<Room>> availableRooms;

    public DataMap() {
        Log.d("Data map: ", "Generating");
        CampusCentre cc = new CampusCentre();
        cc.generateRooms();
        Log.d("Data map: ", "Scheduling");
        cc.generateSchedule();
        availableRooms = cc.getSchedule();
        Log.d("Data map: ", availableRooms.toString());

    }

    public ArrayList<Room> getBusyRooms(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int totalTime = (hour * 100) + 50 * (minute/30);
        Log.d("Total time: ", availableRooms.get(totalTime).toString());
        return availableRooms.get(totalTime);
    }
}
