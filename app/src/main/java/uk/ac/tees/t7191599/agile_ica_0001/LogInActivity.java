package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class LogInActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void signIn(View view) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference dbRef = db.collection("Users");
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);


        Intent intent = new Intent(this, SignUPActivity.class);
        startActivity(intent);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        String Email = et_username.getText().toString();
        String Password = Utility.getMd5(et_password.getText().toString());


        // Create a reference to the cities collection
        CollectionReference Users = db.collection("Users");


        DocumentReference docRef = db.collection("cities").document("SF");
// asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
// ...
// future.get() blocks on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }


    }

}
