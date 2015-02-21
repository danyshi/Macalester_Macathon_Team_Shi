package com.example.andrew.macathon;

import android.os.AsyncTask;
import android.util.Log;

import com.example.andrew.macathon.data.Room;

import java.sql.Time;
import java.util.Calendar;

/**
* Created by guillermovera on 2/21/15.
*/
public class CheckAvailabilityTask extends AsyncTask<String, String, String>{

    private DataMap dataMap = new DataMap();

    private UpdateRoomStatus updateRoom = null;

    private boolean stop = false;

    public CheckAvailabilityTask(UpdateRoomStatus updateRoomStatus) {
        this.updateRoom = updateRoomStatus;
    }

    @Override
    protected String doInBackground(String... params) {
        Log.d("Asynk:", "Doing in background");
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Room room : dataMap.getBusyRooms()) {
                room.makeUnavailable();
                Log.d("Room:", room.getRoomId());
                updateRoom.processRoomStatusChange("not available", room.getRoomId());
            }
            for (Room room : dataMap.getFreeRooms()) {
                room.makeUnavailable();
                Log.d("Room:", room.getRoomId());
                updateRoom.processRoomStatusChange("available", room.getRoomId());
            }
            if (stop) {
                break;
            }
        }
        return "";
    }

}
