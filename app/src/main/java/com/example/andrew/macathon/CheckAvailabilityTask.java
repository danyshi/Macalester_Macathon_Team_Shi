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

    public CheckAvailabilityTask(UpdateRoomStatus updateRoomStatus) {
        this.updateRoom = updateRoomStatus;
    }

    @Override
    protected String doInBackground(String... params) {
        Log.d("Asynk:", "Doing in background");
        while (true) {
            for (Room room : dataMap.getBusyRooms()) {
                if (!room.getOccupationState()) {
                    room.makeUnavailable();
                    Log.d("Room:", room.getRoomId());
                    updateRoom.processRoomStatusChange("not available", room.getRoomId());
                }
            }
            for (Room room : dataMap.getFreeRooms()) {
                if (room.getOccupationState()){
                    room.makeAvailable();
                    Log.d("Room:", room.getRoomId());
                    updateRoom.processRoomStatusChange("available", room.getRoomId());
                }
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        return "";
    }

}
