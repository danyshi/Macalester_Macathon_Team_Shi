package com.example.andrew.macathon;


import android.app.Activity;
import android.os.Bundle;

import com.example.andrew.macathon.data.CampusCentre;


public class MainActivity extends Activity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

             new CheckAvailabilityTask().execute();

        }

}

