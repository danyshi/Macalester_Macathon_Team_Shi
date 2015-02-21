package com.example.andrew.macathon;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.example.andrew.macathon.data.CampusCentre;
import com.example.andrew.macathon.data.Event;
import com.example.andrew.macathon.data.Room;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;


public class MainActivity extends Activity implements UpdateRoomStatus{

    List<Drawable> availableRooms = new ArrayList<>();
    List<Drawable> unavailableRooms = new ArrayList<>();
    private ArrayList<Room> roomsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBackgrounds();
        CampusCentre cc = new CampusCentre();
        this.roomsList = cc.getAllRooms();

        ImageView cc201 = (ImageView) findViewById(R.id.CC201);
        cc201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRoomDetails(0);
            }
        });
        ImageView cc202 = (ImageView) findViewById(R.id.CC202);
        cc202.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRoomDetails(1);
            }
        });
        ImageView cc203 = (ImageView) findViewById(R.id.CC203);
        cc203.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRoomDetails(2);
            }
        });
        ImageView cc204 = (ImageView) findViewById(R.id.CC204);
        cc204.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRoomDetails(3);
            }
        });
        ImageView cc205 = (ImageView) findViewById(R.id.CC205);
        cc205.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRoomDetails(4);
            }
        });
        ImageView cc206 = (ImageView) findViewById(R.id.CC206);
        cc206.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRoomDetails(5);
            }
        });
        ImageView cc207 = (ImageView) findViewById(R.id.CC207);
        cc207.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRoomDetails(6);
            }
        });



        new CheckAvailabilityTask(this).execute();
    }

    public String convertTime(Integer[] times) {
        int startTime, endTime;
        String a, b;
        if (times[0] > 1200) {
            startTime = times[0] - 1200;
            a = "pm";
        } else {
            a = "am";
            startTime = times[0];
        }
        if (times[1] > 1200) {
            endTime = times[1] - 1200;
            b = "pm";
        } else {
            b = "am";
            endTime = times[1];
        }
        int hrsStart = startTime / 100;
        int hrsEnd = endTime / 100;
        int minStart = startTime - 100 * hrsStart;
        int minEnd = endTime - 100 * hrsEnd;
        String minStartString, minEndString;
        if (minStart < 10){
            minStartString = "0" + minStart;
        } else {
            minStartString = Integer.toString(minStart);
        }
        if (minEnd < 10){
            minEndString = "0" + minEnd;
        } else {
            minEndString = Integer.toString(minEnd);
        }
        return hrsStart + ":" + minStartString  + a + " - " + hrsEnd + ":" + minEndString + b + " ";
    }

    public void viewRoomDetails(int roomKey){
        Room r = roomsList.get(roomKey);
        Log.d("room", "ROOM0 NAME:" + r.getName() + "*******************************");
        ArrayList<Event> events = r.getScheduledEvents();
        ArrayList<String> schedule = new ArrayList<String>();

        for (Event e : events){
            Integer[] times = {e.getStartTime(), e.getEndTime()};
            String time = convertTime(times);
            String s = time + e.getTitle();
            schedule.add(time + e.getTitle());
            Log.d("Schedule Item", s + "***********************************");
        }

        RoomDetails roomDetails = new RoomDetails();
        if (schedule.size() != 0){
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("key", schedule);
            roomDetails.setArguments(bundle);
        }
        getFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .add(R.id.container, roomDetails)
                .commit();
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
            Log.d("Making unavailable", roomNumber);
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    roomView.setBackgroundDrawable(unavailableRooms.get(Integer.parseInt(roomNumber) - 1));
                }
            });
        } else {
            final String roomNumber = room.substring(4);
            Log.d("Making available", roomNumber);
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    roomView.setBackgroundDrawable(availableRooms.get(Integer.parseInt(roomNumber) - 1));
                }
            });
        }
    }

    public void roomOnClick(View view) {

    }
}

