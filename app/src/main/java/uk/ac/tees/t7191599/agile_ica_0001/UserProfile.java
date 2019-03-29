package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserProfile extends AppCompatActivity {
    TextView tv_Name,tv_Email,tv_DoB,tv_height,tv_Weight,tv_BMI;
    User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
         u = (User) getIntent().getSerializableExtra("User");

        tv_Name = findViewById(R.id.tv_Name);
        tv_Email = findViewById(R.id.tv_Email);
        tv_DoB = findViewById(R.id.tv_DoB);
        tv_height = findViewById(R.id.tv_Height);
        tv_Weight = findViewById(R.id.tv_Weight);
        tv_BMI = findViewById(R.id.tv_BMI);

        tv_Name.setText(u.getFirst_Name()+" "+u.getSecond_Name());
        tv_Email.setText(u.getEmail());
        tv_height.setText(u.getCurrent().getHeight().toString());
        tv_Weight.setText(u.getCurrent().getWeight().toString());
        tv_BMI.setText(u.getCurrent().getBMI().toString());

        Long date = u.getDoB();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);

        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        fmt.setCalendar(cal);
        String dateFormatted = fmt.format(cal.getTime());

        tv_DoB.setText(dateFormatted);

    }

    public void edit(View view){
        Intent intent = new Intent(this, EditProfile.class);
        intent.putExtra("User",u);
        startActivity(intent);

    }
}
