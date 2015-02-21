package com.example.andrew.macathon;

import android.app.Fragment;
import android.os.Bundle;
<<<<<<< HEAD
=======
import android.support.annotation.Nullable;
>>>>>>> ddbee03c39ddb58a6d4d700b26c823e15d5a77c1
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
<<<<<<< HEAD
import android.widget.ListView;

import java.util.ArrayList;
=======
>>>>>>> ddbee03c39ddb58a6d4d700b26c823e15d5a77c1

/**
 * Created by andrew on 2/20/15.
 * Manages the collection of rooms and updates their appearance based on the current time
 */
public class FloorFragment extends Fragment {

<<<<<<< HEAD
    private ArrayAdapter<String> mRoomAdaptor;

    public FloorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_floor, container, false);

        ArrayList<String> placeHolder = null;

        mRoomAdaptor = new ArrayAdapter<String>(getActivity(), R.layout.fragment_floor, R.id.listView, placeHolder);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(mRoomAdaptor);

        return rootView;


=======


    ListView listView = (ListView) findViewById(R.id.floor_view);
    listView.setAdapter(adapter);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.floor_view, room_array);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
>>>>>>> ddbee03c39ddb58a6d4d700b26c823e15d5a77c1
    }
}
