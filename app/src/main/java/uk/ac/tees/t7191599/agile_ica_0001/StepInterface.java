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
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aaron on 03/03/2019.
 */

public class StepInterface extends AppCompatActivity implements SensorEventListener, StepListener {

    public TextView textView;
    public StepDetector simpleStepDetector;
    public static SensorManager sensorManager;
    public Sensor accel;
    public static final String TEXT_NUM_STEPS = "Number of Steps: ";
    public static int numSteps;
    public TextView TvSteps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepinterface);


        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

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


    }








    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
    }


}
