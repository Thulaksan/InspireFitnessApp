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
            int Steps = Integer.valueOf(StepsTaken);
            Double Cal = CalcCal(Steps);



            Double Ratio = 0.415;
            Double Hieght_CM = 176.00;

            Double Step_Length = Hieght_CM * Ratio;
            Double Distance_CM = Step_Length * Step_Length;
            Double Distance = Distance_CM * 100000;
            Double Distance_Mile =  Distance / 1.609;
            Double Seconds_Walked = Distance_Mile / 0.00083333333;
            Double Minutes = Seconds_Walked / 60;
            tv_steps.setText(Steps);
            tv_time.setText(Minutes.toString());
            tv_distance.setText(Distance.toString());
            tv_calories.setText(Cal.toString());
        }
    };
    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(broadcastReceiver);
    }


    public Double CalcCal(int Steps){
        double per  = 0.05;
        return per* Steps;


    }
}



