package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

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
        System.out.println("Thomas");
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }



    public void signIn(final View view) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);


        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        String Email = et_username.getText().toString();
        final String Password = Utility.getMd5(et_password.getText().toString());


        // Create a reference to the cities collection
        CollectionReference Users = db.collection("Users");

        // Create a query against the collection.
        Query user = Users.whereEqualTo("Email", Email);
        user.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        User TempUser = queryDocumentSnapshots.getDocuments().get(0).toObject(User.class);
                        if (TempUser.Password.equals(Password)) {

                            Toast.makeText(LogInActivity.this, TempUser.Email+" "+TempUser.First_Name+" "+TempUser.Second_Name, Toast.LENGTH_SHORT).show();
                            LoggedIn(view);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LogInActivity.this, "FAILED TO DO STTUFF", Toast.LENGTH_SHORT).show();

            }
        });


    }

}
