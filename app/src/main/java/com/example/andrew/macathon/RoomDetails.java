package com.example.andrew.macathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by danyshi on 2/21/2015.
 */
public class RoomDetails extends android.app.Fragment {

    public RoomDetails() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_roomdetails, container, false);


        String[] strArray = {"Time 1", "Time 2", "Time 3"};

        if (getArguments() != null){
            Bundle bundle = getArguments();
             ArrayList<String> data = bundle.getStringArrayList("key");

            strArray = data.toArray(strArray);

        } else {
            Log.d("======>", "arguments was nul ****************************************");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                strArray);

        ListView listView = (ListView) rootView.findViewById(R.id.room_details_listView);
        listView.setAdapter(adapter);

        Button button = (Button) rootView.findViewById(R.id.return_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootView.setVisibility(View.GONE);
            }
        });
        return rootView;
    }
}
