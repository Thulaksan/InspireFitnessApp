package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalcActivity extends AppCompatActivity {


    EditText et_height,et_weight;
    TextView tv_BMI_Status,tv_BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        tv_BMI_Status = findViewById(R.id.tv_BMI_Status);
        tv_BMI = findViewById(R.id.tv_BMI);


    }


    public void calc(View view){

        String h = et_height.getText().toString().trim();
        String w = et_weight.getText().toString().trim();
        Double height = Double.parseDouble(h);
        Double weight = Double.parseDouble(w);
        Double BMI= weight/(height* height);
        String BMIStat="";

        if(BMI>30){
            BMIStat ="obese";
        }else if(BMI<29.99 && BMI>25){
            BMIStat ="overweight";
        } else if(BMI<24.99 && BMI>18.5){
            BMIStat ="healthy";
        }else if(BMI<18.5 ){
            BMIStat ="underweight";
        }
        tv_BMI_Status.setText(BMIStat);
        tv_BMI.setText(BMI.toString());

    }

    public void Back(View view){

        User u = (User) getIntent().getSerializableExtra("User");
        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("User",u);
        startActivity(intent);
    }
}
