package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

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
            tv_steps.setText(StepsTaken);

//------------------------------------Assumptions------------------------------------
// https://livehealthy.chron.com/determine-stride-pedometer-height-weight-4518.html
// Stride Length  = Hieght in CM * 0.415
// Kilometer = CM * 100000
// Mile = KiloMeter / 1.609
// https://www.verywellfit.com/convert-miles-to-kilometers-and-walking-time-3876685
//Distance_Per_5_Min = 0.25 Miles
//Distance_Per_1_Min = 0.05 Miles
//Distance_Per_1_Second = 0.00083333333 Miles
//Seconds_Walked = Miles /  0.00083333333
//-----------------------------------------------------------------------------------

            Double steps = Double.valueOf(StepsTaken);
            Double Ratio = 0.415;
            Double Hieght_CM  = 65.0;

            Double Step_Length = Hieght_CM * Ratio;
            Double Distance_CM = Step_Length * steps;
            Double Distance_KM = Distance_CM / 100000;
            Double Distance_Mile =  Distance_KM / 1.609;
            Double Seconds_Walked = Distance_Mile / 0.00083333333;
            Double Minutes = Seconds_Walked / 60;
            Double Cal = steps * 0.05;


            String m = new DecimalFormat("#.##").format(Minutes);
            String d = new DecimalFormat("#.##").format(Distance_KM);
            String c = new DecimalFormat("#.##").format(Cal);
            tv_time.setText(m+" Minutes");
            tv_distance.setText(d+" km");
            tv_calories.setText(c);




        }
    };
    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(broadcastReceiver);
    }
}
