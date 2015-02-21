package macathon;

import android.os.Bundle;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andrew.macathon.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by danyshi on 2/21/2015.
 */
public class RoomDetails extends Fragment {

    public RoomDetails() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_roomdetails, container, false);

        String[] strArray = {"No events today."};
        ArrayList<String> data = getArguments().getStringArrayList("key");
        if (data.size() > 1){
            strArray = Arrays.copyOfRange(data.toArray(strArray), 1, data.size());
        } else {
            Log.d("======>", "arguments was nul ****************************************");
        }
        String roomName = data.get(0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                strArray);

        ListView listView = (ListView) rootView.findViewById(R.id.room_details_listView);
        listView.setAdapter(adapter);

        TextView textView = (TextView) rootView.findViewById(R.id.room_name);
        textView.setText(roomName);

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
