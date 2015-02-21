package com.example.andrew.macathon;

<<<<<<< HEAD
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
=======
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
>>>>>>> 9afa17423b89bf1d159495acafe8b3e6817ba44f

/**
 * Created by andrew on 2/20/15.
 * Where the view of calendar events lives. SHould pop up when a room is clicked from the floor fragment
 */
<<<<<<< HEAD
public class RoomFragment extends Fragment{

    // A listview where each item is an Event

    public RoomFragment(){
=======
public class RoomFragment extends Fragment {

    public RoomFragment() {
>>>>>>> 9afa17423b89bf1d159495acafe8b3e6817ba44f

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
<<<<<<< HEAD
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

=======
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
>>>>>>> 9afa17423b89bf1d159495acafe8b3e6817ba44f
}
