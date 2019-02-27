package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    private eventAdapter adapter;
    private ListView listViewEvents;
    private ArrayList<Event> events = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        populateListView();


    }


    public void populateListView()
    {
        listViewEvents = (ListView) findViewById(R.id.eventListView);
        events.add(new Event("Step Tracker","22/06/2020"));
        events.add(new Event("Workout","01/12/2019"));
        events.add(new Event("Meal Plan","14/08/2019"));
        events.add(new Event("Workout","11/12/2019"));
        adapter= new eventAdapter(this,events);
        listViewEvents.setAdapter(adapter);

    }




    public void CreateEvent(View view)
    {
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }
}
