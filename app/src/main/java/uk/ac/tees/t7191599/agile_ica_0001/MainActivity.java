package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gottologin(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);


    }

    public void gottolist(View view) {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }

    public void gottoProfile(View view) {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }

    //Andrew Powell


    //Thomas Black


    //Tac


    //Aaron

    public void gotosteptracker(View view){
        Intent intent = new Intent(this, StepInterface.class);
        startActivity(intent);
    }


    //Jason
}
