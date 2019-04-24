package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service implements SensorEventListener {


    private SensorManager SM;
    private Sensor SC;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPastValue() {
        return PastValue;
    }

    public void setPastValue(int pastValue) {
        PastValue = pastValue;
    }

    private int value;
    private int PastValue;






    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        SC = SM.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        SM.registerListener(this, SC, 0);

        return START_STICKY;
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        Toast.makeText(this, "Sen Change", Toast.LENGTH_SHORT).show();
        float[] values;
        values = event.values;
        value = (int) values[0];
        value = value - PastValue;
        Toast.makeText(this, "Values is "+value, Toast.LENGTH_SHORT).show();
        Intent i = new Intent("Steps");
        i.putExtra("Steps", String.valueOf(value));
        sendBroadcast(i);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}