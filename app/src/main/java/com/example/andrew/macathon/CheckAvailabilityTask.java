package com.example.andrew.macathon;

import android.os.AsyncTask;
import android.util.Log;

import com.example.andrew.macathon.data.Room;

/**
 * Created by guillermovera on 2/21/15.
 */
public class CheckAvailabilityTask extends AsyncTask<String, String, String> {

    DataMap dataMap = new DataMap();

    @Override
    protected String doInBackground(String... params) {
        for (Room room : dataMap.getBusyRooms()){
            room.makeUnavailable();
        }

        return "";
    }
}
