package uk.ac.tees.t7191599.agile_ica_0001;

/**
 * Created by aaron on 03/03/2019.
 */

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.arch.lifecycle.Lifecycle.Event;


import com.google.api.Context;

/**
 * Created by aaron on 03/03/2019.
 */

public class StepInterface extends AppCompatActivity implements SensorEventListener
 {

    //public TextView textView;
   // public StepDetector simpleStepDetector;
   // public static SensorManager sensorManager;
    //public Sensor accel;
    //public static final String TEXT_NUM_STEPS = "Number of Steps: ";
   // public static int numSteps;
  // public TextView TvSteps;

    SensorManager sensorManager;
    TextView tv_steps;
    boolean runing = false;


    @Override
     protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.stepinterface);

        tv_steps = (TextView)findViewById(R.id.tv_steps);

      sensorManager = (SensorManager) getSystemService(StepInterface.SENSOR_SERVICE);

    }


    @Override
    public void onResume( ) {
       super.onResume();
       runing = true;
       Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
       if (countSensor != null) {
          sensorManager.registerListener(this, countSensor, sensorManager.SENSOR_DELAY_UI);

       }else {
          Toast.makeText(this, "sensor not found", Toast.LENGTH_SHORT).show();
       }
    }

    @Override
    protected void onPause() {
       super.onPause();

       runing = false;
      // sensorManager.unregisterListener(this );
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
      if (runing) {
          tv_steps.setText(String.valueOf(event.values[0]));
      }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }



    // Get an instance of the SensorManager
      //  sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
      //  accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //simpleStepDetector = new StepDetector();
        //simpleStepDetector.registerListener(this);

      //  Button Start = findViewById(R.id.btn_start);


       // Start.setOnClickListener(new android.view.View.OnClickListener() {
            //@Override
          //  public void onClick(android.view.View arg0) {
               // this.BtnStart();
          //  }

           // private void BtnStart() {
               // numSteps =0;
               // sensorManager.registerListener(StepInterface.this,accel,SensorManager.SENSOR_DELAY_FASTEST);
          //  }
       // });


   // }








    //@Override
   // public void onAccuracyChanged(Sensor sensor, int accuracy) {
   // }

   // @Override
   // public void onSensorChanged(SensorEvent event) {
       // if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
      //      simpleStepDetector.updateAccel(
         //           event.timestamp, event.values[0], event.values[1], event.values[2]);
        //}
   // }

 //   @Override
  //  public void step(long timeNs) {
    //    numSteps++;
     //   TvSteps.setText(TEXT_NUM_STEPS + numSteps);
  //  }


}
