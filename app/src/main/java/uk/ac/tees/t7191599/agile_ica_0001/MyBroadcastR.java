package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MyBroadcastR extends BroadcastReceiver {

    MyService s;
    public MyBroadcastR(Context context) {

         s = new MyService();
        context.startService(new Intent(context, MyService.class));
        Intent intent = new Intent(context, StepTracker.class);
        context.startActivity(intent);
    }

    public MyBroadcastR() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Its Working", Toast.LENGTH_SHORT).show();
        s.setPastValue(s.getValue());
    }
}