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
import com.example.andrew.macathon.data.Room;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;


public class MainActivity extends Activity implements UpdateRoomStatus{

    List<Drawable> availableRooms = new ArrayList<>();
    List<Drawable> unavailableRooms = new ArrayList<>();
    private DataMap dataMap = new DataMap();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBackgrounds();
        ImageView cc201 = (ImageView) findViewById(R.id.CC201);
        cc201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setVisible(false);
                RoomDetails roomDetails = new RoomDetails();
                Bundle bundle = new Bundle();

                //TODO: hardcode or pull out schedule

                viewRoomDetails();

                String[] strArray = {"test1", "test2", "test3"};
                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(strArray));
                bundle.putStringArrayList("key", arrayList);
                roomDetails.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                        .add(R.id.container, roomDetails)
                        .commit();
            }
        });

        new CheckAvailabilityTask(this).execute();
    }

//    public String convertTime(Integer[] times){
//        if (){
//
//        }
//        return null;
//    }

    public void viewRoomDetails(){
        List<Room> roomsList = dataMap.getData();
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

