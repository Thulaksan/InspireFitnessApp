package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class EditProfile extends AppCompatActivity {



    EditText et_height,et_weight;
    TextView tv_name;
    User u;
    Firebase firebase= new Firebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        User u = (User) getIntent().getSerializableExtra("User");
        tv_name = findViewById(R.id.tv_Name);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        tv_name.setText(u.getFirst_Name()+" "+u.getSecond_Name());
    }

    public void Update(View View){

        String h = et_height.getText().toString().trim();
        String w = et_weight.getText().toString().trim();
        Double height = Double.parseDouble(h);
        Double weight = Double.parseDouble(w);
        Calendar Cal = Calendar.getInstance();
        Long Date = Cal.getTimeInMillis();
        Body_Details bd = new Body_Details(height,weight,Date);
        u.setCurrent(bd);
        u.getBodyHistory().add(bd);
        firebase.DBUser(u);

        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("User",u);
        startActivity(intent);

    }
}
