package com.example.andrew.macathon;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.andrew.macathon.data.CampusCentre;
import com.example.andrew.macathon.data.Room;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;


public class MainActivity extends Activity implements UpdateRoomStatus{

    List<Drawable> availableRooms = new ArrayList<>();
    List<Drawable> unavailableRooms = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBackgrounds();

        new CheckAvailabilityTask(this).execute();
    }

    private void setBackgrounds() {
        availableRooms.add(getResources().getDrawable(R.drawable.room_0_available));
        availableRooms.add(getResources().getDrawable(R.drawable.room_1_available));
        availableRooms.add(getResources().getDrawable(R.drawable.room_2_available));
        availableRooms.add(getResources().getDrawable(R.drawable.room_3_available));
        availableRooms.add(getResources().getDrawable(R.drawable.room_4_available));
        availableRooms.add(getResources().getDrawable(R.drawable.room_5_available));
        availableRooms.add(getResources().getDrawable(R.drawable.room_6_available));

        unavailableRooms.add(getResources().getDrawable(R.drawable.room_0_unavailable));
        unavailableRooms.add(getResources().getDrawable(R.drawable.room_1_unavailable));
        unavailableRooms.add(getResources().getDrawable(R.drawable.room_2_unavailable));
        unavailableRooms.add(getResources().getDrawable(R.drawable.room_3_unavailable));
        unavailableRooms.add(getResources().getDrawable(R.drawable.room_4_unavailable));
        unavailableRooms.add(getResources().getDrawable(R.drawable.room_5_unavailable));
        unavailableRooms.add(getResources().getDrawable(R.drawable.room_6_unavailable));


    }

    @Override
    public void processRoomStatusChange(String action, String room) {
        int resID = getResources().getIdentifier(room, "id", getPackageName());
        Log.d("ID:", String.valueOf(resID));
        final ImageView roomView = (ImageView) findViewById(resID);
        if (action.equals("not available")) {
            final String roomNumber = room.substring(4);
            Log.d("TEST", roomNumber);
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    roomView.setBackgroundDrawable(unavailableRooms.get(Integer.parseInt(roomNumber) - 1));
                }
            });
        } else {

        }
    }

    public void roomOnClick(View view) {

    }
}

