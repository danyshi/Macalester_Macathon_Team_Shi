package com.example.andrew.macathon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andrew on 2/20/15.
 * Where the view of calendar events lives. SHould pop up when a room is clicked from the floor fragment
 */
public class RoomFragment extends Fragment{

    // A listview where each item is an Event

    public RoomFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
