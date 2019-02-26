package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class SignUPActivity extends AppCompatActivity {

    private EditText et_firstname;
    private EditText et_lastname;
    private EditText et_email;
    private EditText et_Conform_Email;
    private EditText et_Password;
    private EditText et_Conform_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }


    public void SignUp(View V){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);


        et_firstname = findViewById(R.id.et_firstname);
        et_lastname= findViewById(R.id.et_lastname);
        et_email = findViewById(R.id.et_email);
        et_Conform_Email= findViewById(R.id.et_Conform_Email);
        et_Password = findViewById(R.id.et_Password);
        et_Conform_Password= findViewById(R.id.et_Conform_Password);


        String TempPass="";
        String TempEmail= "";

        if(et_email.getText().toString().equals(et_Conform_Email.getText().toString())){
            TempEmail= et_email.getText().toString();
        }else{
            //Send Form Back to user
        }
        String Pass1 = Utility.getMd5(et_Password.getText().toString());
        String Pass2 = Utility.getMd5(et_Conform_Password.getText().toString());
        if(Pass1.equals(Pass2)){
            TempPass = Pass1;
        }else{
            //Send Form Back to user
        }



        User TempUser = new User();
        TempUser.First_Name= et_firstname.getText().toString();
        TempUser.Second_Name = et_lastname.getText().toString();
        TempUser.Email = TempEmail;
        TempUser.Password = TempPass;

        db.collection("Users")
                .add(TempUser)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(SignUPActivity.this, "Signedup", Toast.LENGTH_SHORT).show();
                        Log.d("Signup", "DocumentSnapshot added with ID: " + documentReference.getId());
                        System.out.println("Worked");

                        //Goto User Page
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUPActivity.this, "SignupError", Toast.LENGTH_SHORT).show();
                        Log.w("Signup", "Error adding document", e);
                        System.out.println("Worked");
                    }
                });





    }
}
