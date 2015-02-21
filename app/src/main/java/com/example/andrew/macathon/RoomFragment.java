package com.example.andrew.macathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by andrew on 2/20/15.
 * Where the view of calendar events lives. SHould pop up when a room is clicked from the floor fragment
 */
public class RoomFragment extends Fragment {

    public RoomFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.room_view, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.room_view, R.id.room_view_list);
        ListView listView = (ListView) getActivity().findViewById(R.id.room_view_list);
        listView.setAdapter(adapter);
        return view;
    }

    public static RoomFragment newInstance() {
        RoomFragment fragment = new RoomFragment();
        return fragment;
    }
}
