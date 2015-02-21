package macathon;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.andrew.macathon.R;


public class CampusActivity extends ActionBarActivity {
    private String[] buildings;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        buildings = new String[]{"1 Chinese House",
                "2 Ecohouse",
                "3 Spanish House",
                "4 German House",
                "5 French House",
                "6 Japanese House",
                "7 Russian House",
                "8 RA House",
                "9 Baseball, Softball Fields, and Tennis Courts",
                "10 Athletic Fields and Track",
                "11 Stadium& Stadium Residence Hall",
                "12 Wind Turbine",
                "13 Leonard Center",
                "14 Shaw Field",
                "15 Olin-Rice Science Center",
                "18 Janet Wallace Fine Arts Center",
                "24 Duplex",
                "25 Carnegie Hall",
                "26 Old Main",
                "27 DeWitt Wallace Library",
                "28 Kirk Residence Hall",
                "29 Ruth Stricker Dayton Campus Center",
                "30 Weyerhaeuser Memorial Chapel",
                "31 Weyerhaeuser Hall",
                "32 77 Macalester",
                "33 High Winds& Office of Special Events",
                "34 Accounts Payable & Purchasing",
                "35 Macalester Cottages",
                "36 Cultural House",
                "37 Macalester Street",
                "37 Grand Cambridge Apartments",
                "38 George Draper Dayton Residence Hall",
                "39 Hugh S. Alexander Alumni House",
                "40 President’s House",
                "41 Wallace Residence Hall",
                "42 30 Macalester Residence Hall",
                "43 Bigelow Residence Hall",
                "44 Turck Residence Hall",
                "45 Doty Residence Hall",
                "46 Dupre Residence Hall",
                "47 Kagin Commons",
                "48 Markim Hall",
                "49 Lampert Building",
                "50 Summit House"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buildings);
        ListView listView = (ListView) findViewById(R.id.building_listView);
        listView.setAdapter(adapter);

        final int ccPosition = 21;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == ccPosition){
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campus, menu);
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


    static public class BuildingListFragment extends Fragment{

        public BuildingListFragment(){

        }

    }
}
