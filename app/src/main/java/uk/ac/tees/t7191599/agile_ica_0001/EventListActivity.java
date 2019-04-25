package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class EventListActivity extends AppCompatActivity {



    private eventAdapter adapter;
    private ListView listViewEvents;
    private ArrayList<Event> events ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        populateListView();
        MyBroadcastR mbr = new MyBroadcastR(getBaseContext());

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, MyBroadcastR.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        alarmManager.setExact(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

        listViewEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == position)
                {
                    if (events.get(position).getName().matches("Meal planner"))
                    {
                        Intent intent = new Intent(view.getContext(), NutritionPlanner.class);
                        User u = (User) getIntent().getSerializableExtra("User");

                        MealPlannerEvent mEvent = (MealPlannerEvent) u.getEvents().get(position).getMeal();


                        intent.putExtra("User",u);
                        intent.putExtra("position", mEvent);
                        startActivity(intent);
                    }
                    else if (events.get(position).getName().matches("gym activity"))
                    {
                        Intent intent = new Intent(view.getContext(), Gymactivity.class);
                        User u = (User) getIntent().getSerializableExtra("User");

                        GymEvent gymEvent = u.getEvents().get(position).getGymEvent();
                        intent.putExtra("User",u);
                        intent.putExtra("position", gymEvent);
                        startActivity(intent);

                    }

                }
            }
        });




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
        User u = (User) getIntent().getSerializableExtra("User");
        Intent intent = new Intent(this,toutoralPage.class);
        intent.putExtra("User",u);
        startActivity(intent);
    }

}