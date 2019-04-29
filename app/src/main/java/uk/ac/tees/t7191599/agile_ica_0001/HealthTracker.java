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
    Long Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tracker);
        u = (User) getIntent().getSerializableExtra("User");
        Date = Calendar.getInstance().getTimeInMillis();
    }


    public void Water(View view){

            et_Water = findViewById(R.id.et_weight);
            String w =et_Water.getText().toString().trim();

        if (w ==null) {
            et_Water.setError("This Cant be Empty");
            et_Water.requestFocus();
            return;
        }
            int Water = Integer.parseInt(w);
            WaterTracker x = new WaterTracker(Water,Date);
            Event e = new Event("Water",Date);
            e.setWt(x);
            u.getEvents().add(e);
            u.getWater().add(x);



        }

    public void Sleep(View view){
        et_Sleep = findViewById(R.id.et_height);
        String s = et_Sleep.getText().toString().trim();

        if (s ==null) {
            et_Sleep.setError("This Cant be Empty");
            et_Sleep.requestFocus();
            return;
        }
        int Sleep = Integer.parseInt(s);
        SleepTracler x = new SleepTracler(Sleep,Date);
        Event e = new Event("Sleep",Date);
        e.setSt(x);

        u.getEvents().add(e);
        u.getSleep().add(x);
    }

    public void Finish(View view){
        firebase.DBUser(u);
        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("User",u);
        startActivity(intent);


    }
}
