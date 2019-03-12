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



/**
 * Created by aaron on 03/03/2019.
 */


public class StepInterface extends AppCompatActivity implements SensorEventListener {

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

}



