package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateEventActivity extends AppCompatActivity {
    ListView lv;
    String[] eventTypes = new String[]{"Gym Event", "Step Tracker", "Meal Plan", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        lv = (ListView) findViewById(R.id.Event_List);

        List<String> eventList = new ArrayList<String>(Arrays.asList(eventTypes));

        ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventList) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.RED);
                return view;
            }
        };
        lv.setAdapter(stringAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {

                    Intent intent = new Intent(view.getContext(), Gymactivity.class);
                    User u = (User) getIntent().getSerializableExtra("User");
                    intent.putExtra("User",u);
                    startActivity(intent);

                }
                if (position == 1)
                {
                    Intent intent = new Intent(view.getContext(), StepInterface.class);
                    User u = (User) getIntent().getSerializableExtra("User");
                    intent.putExtra("User",u);
                    startActivity(intent);

                }

                if (position == 2)
                {
                    Intent intent = new Intent(view.getContext(), NutritionPlanner.class);
                    User u = (User) getIntent().getSerializableExtra("User");
                    intent.putExtra("User",u);
                    startActivity(intent);
                }

                if (position == 3)
                {



                }

                if (position == 4)
                {


                }








            }
        });




    }



}
