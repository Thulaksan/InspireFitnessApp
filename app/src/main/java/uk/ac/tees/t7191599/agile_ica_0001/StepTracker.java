package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StepTracker extends AppCompatActivity {
    TextView tv_Steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_tracker);
        registerReceiver(broadcastReceiver, new IntentFilter("Steps"));


    }


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String StepsTaken = intent.getStringExtra("Steps");
            tv_Steps = findViewById(R.id.tv_Steps);
            int Steps = Integer.valueOf(StepsTaken);
            tv_Steps.setText(String.format("you have walked %s", Steps));
        }
    };
    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(broadcastReceiver);
    }
}
