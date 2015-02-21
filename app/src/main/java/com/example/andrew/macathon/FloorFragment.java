package com.example.andrew.macathon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by andrew on 2/20/15.
 * Manages the collection of rooms and updates their appearance based on the current time
 */
public class FloorFragment extends Fragment {

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


    }
}
