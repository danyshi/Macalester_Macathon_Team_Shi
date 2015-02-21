package com.example.andrew.macathon;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

import com.example.andrew.macathon.data.Room;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.floor_view);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    //TODO: switch room frag to mainfrag
                    .add(R.id.container, new RoomFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class MainFragment extends Fragment {
        private Button room1;
        private Button room2;
        private Button room3;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //return super.onCreateView(inflater, container, savedInstanceState);
//            getActivity().setContentView(R.layout.floor_view);
            final View rootView = inflater.inflate(R.layout.floor_view, container, false);


            room1 = (Button) rootView.findViewById(R.id.room1);
            room1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {

                    //showRoom(rootView);
                    rootView.setVisibility(View.GONE);


//                    Intent intent = new Intent(getActivity(), Room.class);
//                    startActivity(intent);
                }
            });
            room2 = (Button) rootView.findViewById(R.id.room2);
            room2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Room.class);
                    startActivity(intent);
                }
            });
            room3 = (Button) rootView.findViewById(R.id.room3);
            room3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Room.class);
                    startActivity(intent);
                }
            });


            return rootView;
        }

        public void showRoom(View view){
            Fragment roomFrag = new RoomFragment();

            FragmentManager fm = getActivity().getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            //transaction.add(R.layout.floor_view, roomFrag);
            transaction.commit();

        }
    }

}

