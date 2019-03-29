package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class HealthTracker extends AppCompatActivity {

    EditText et_Sleep,et_Water;
    User u;
    Firebase firebase= new Firebase();
    Long Date = Calendar.getInstance().getTimeInMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tracker);
        u = (User) getIntent().getSerializableExtra("User");
    }


    public void Water(View view){

            et_Water = findViewById(R.id.et_weight);
            String w =et_Water.getText().toString().trim();
            int Water = Integer.parseInt(w);
            WaterTracker x = new WaterTracker(Water,Date);
            u.getEvents().add(x);

        }

    public void Sleep(View view){
        et_Sleep = findViewById(R.id.et_height);
        String s =et_Sleep.getText().toString().trim();
        int Sleep = Integer.parseInt(s);
        SleepTracler x = new SleepTracler(Sleep,Date);
        u.getEvents().add(x);

    }

    public void Finish(View view){
        firebase.DBUser(u);
        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("User",u);
        startActivity(intent);


    }
}
