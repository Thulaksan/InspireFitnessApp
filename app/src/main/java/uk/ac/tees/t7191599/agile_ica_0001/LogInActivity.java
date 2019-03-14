package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }
    public void SignUP(View view) {
        Intent intent = new Intent(this, SignUPActivity.class);
        startActivity(intent);
    }




    public void LoggedIn(View view) {

        Firebase fb = new Firebase();
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        String Email = et_username.getText().toString();
        String Password = et_password.getText().toString();




            if (!Patterns.EMAIL_ADDRESS.matcher(et_username.getText().toString().trim()).matches()) {
                et_username.setError("This Needs to be an valid Email Address");
                et_username.requestFocus();
                return;
            }

            if (et_password.length() <= 6) {
                Toast.makeText(LogInActivity.this, "Passwords Need to be greater than 6 characters", Toast.LENGTH_SHORT).show();
                et_password.setError("Passwords Need to be greater than 6 characters");
                et_password.requestFocus();
                return;
            }
        fb.setAct(this);
        fb.SignIn(Email,Password);






    }

}
