package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StepTracker extends AppCompatActivity {
    TextView tv_steps,tv_time,tv_distance,tv_calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_tracker);
        registerReceiver(broadcastReceiver, new IntentFilter("Steps"));
        tv_steps = findViewById(R.id.tv_step);
        tv_time = findViewById(R.id.tv_time);
        tv_distance = findViewById(R.id.tv_distance);
        tv_calories = findViewById(R.id.tv_calories);


    }


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String StepsTaken = intent.getStringExtra("Steps");
            ;
            int Steps = Integer.valueOf(StepsTaken);
            tv_steps.setText(String.format("you have walked %s", Steps));
        }
    };
    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(broadcastReceiver);
    }
}
