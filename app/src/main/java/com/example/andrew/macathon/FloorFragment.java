package com.example.andrew.macathon;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by andrew on 2/20/15.
 * Manages the collection of rooms and updates their appearance based on the current time
 */
public class FloorFragment extends Fragment {



    ListView listView = (ListView) findViewById(R.id.floor_view);
    listView.setAdapter(adapter);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.floor_view, room_array);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
