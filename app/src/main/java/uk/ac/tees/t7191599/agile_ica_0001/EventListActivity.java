package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {



    private eventAdapter adapter;
    private ListView listViewEvents;
    private ArrayList<Event> events ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        populateListView();





    }
    public void populateListView()
    {

        User u = (User) getIntent().getSerializableExtra("User");
        events = u.getEvents();
        listViewEvents = (ListView) findViewById(R.id.eventListView);
        adapter= new eventAdapter(this,events);
        listViewEvents.setAdapter(adapter);

    }




    public void CreateEvent(View view)
    {
        User u = (User) getIntent().getSerializableExtra("User");
        Intent intent = new Intent(this, CreateEventActivity.class);
        intent.putExtra("User",u);
        startActivity(intent);
    }
    public void viewProfile(View view)
    {
        User u = (User) getIntent().getSerializableExtra("User");
        Intent intent = new Intent(this, UserProfile.class);
        intent.putExtra("User",u);
        startActivity(intent);

    }
    public void viewVideos(View view){
        Intent intent = new Intent(this,toutoralPage.class);
        startActivity(intent);
    }
}