package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUPActivity extends AppCompatActivity {

    private ArrayList<EditText> inputs = new ArrayList<EditText>();
    private ProgressBar ProgressBar;
    private EditText et_email;
    private EditText et_Confirm_Email;
    private EditText et_Password;
    private EditText et_Confirm_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void SignUp(View view) {
        Firebase fb = new Firebase();


        et_email = findViewById(R.id.et_email);
        et_Confirm_Email = findViewById(R.id.et_Confirm_Email);
        et_Password = findViewById(R.id.et_Password);
        et_Confirm_Password = findViewById(R.id.et_Confirm_Password);
        ProgressBar = findViewById(R.id.ProgressBar);

        inputs.add(et_email);
        inputs.add(et_Confirm_Email);
        inputs.add(et_Password);
        inputs.add(et_Confirm_Password);

        for (EditText edit : inputs) {
            if (edit.getText().toString().trim().equals("")) {

                edit.setError("This Is Required");
                edit.requestFocus();
                return;
            }
        }

        String TempPass = "";
        String TempEmail = "";

        if (et_email.getText().toString().trim().equals(et_Confirm_Email.getText().toString().trim())) {

            if (!Patterns.EMAIL_ADDRESS.matcher(et_email.getText().toString().trim()).matches()) {
                et_email.setError("This Needs to be an Email Address");
                et_email.requestFocus();
                return;

            } else {
                TempEmail = et_email.getText().toString().trim();
            }

        } else {

            et_email.setError("Emails Need to Match");
            et_email.requestFocus();
            return;
        }

        if (et_Password.getText().toString().trim().equals(et_Confirm_Password.getText().toString().trim())) {

            if (et_Password.getText().toString().trim().length() <= 6) {
                Toast.makeText(SignUPActivity.this, "Passwords Need to be greater than 6 characters", Toast.LENGTH_SHORT).show();
                et_Password.setError("Passwords Need to be greater than 6 characters");
                et_Password.requestFocus();
                return;
            } else {

                TempPass = et_Password.getText().toString().trim();
            }

        } else {
            et_Confirm_Password.setError("Passwords Need to Match");
            et_Confirm_Password.requestFocus();
            return;
        }

        ProgressBar.setVisibility(View.VISIBLE);
        fb.setAct(this);
        fb.SignUp(TempEmail,TempPass);
        Intent intent = new Intent(this, First_loginActivity.class);
        startActivity(intent);
        }

//        User TempUser = new User();
//
//        TempUser.Email = TempEmail;
//        TempUser.Password = TempPass;
//
//        db.collection("Users")
//                .add(TempUser)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(SignUPActivity.this, "Signedup", Toast.LENGTH_SHORT).show();
//                        Log.d("Signup", "DocumentSnapshot added with ID: " + documentReference.getId());
//                        System.out.println("Worked");
//
//                        //Goto User Page
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(SignUPActivity.this, "SignupError", Toast.LENGTH_SHORT).show();
//                        Log.w("Signup", "Error adding document", e);
//                        System.out.println("Worked");
//                    }
//                });
//    }
}
