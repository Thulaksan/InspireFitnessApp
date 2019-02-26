package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends AppCompatActivity {
    ListView listv;
    String[] ev= new String[]{"apples", "apirs", "donkys", "newbirds", "cats", "Dogs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        listv = (ListView) findViewById(R.id.ListView);
        ArrayAdapter adapter = new ArrayAdapter(EventListActivity.this,android.R.layout.simple_expandable_list_item_1,ev);
        listv.setAdapter(adapter);
    }
    public void CreateEvent(View view)
    {
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }
}
