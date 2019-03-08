package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.SetOptions;

import java.io.Serializable;

public class Firebase implements Serializable {


    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private FirebaseFirestoreSettings settings;
    private Activity act;
    private User user;


    public Firebase() {
        db = FirebaseFirestore.getInstance();


        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();

    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void SignUp(String Email, String Password) {



        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getAct(), "Registered", Toast.LENGTH_SHORT).show();
                }else{

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getAct(), "You are already registered", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getAct(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    public void SignIn(String Email, String Password) {

        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                  //  finish();
                    Intent intent = new Intent(getAct(), EventListActivity.class);
                    getAct().startActivity(intent);

                } else {
                    Toast.makeText(getAct(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


    public Activity getAct() {
        return act;
    }

    public void setAct(Activity act) {
        this.act = act;
    }

    public void DBUser(User Temp){
        db.collection("Users").document(mAuth.getCurrentUser().getEmail())
                .set(Temp, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getAct() , "SignupError", Toast.LENGTH_SHORT).show();
                        Log.w("Signup", "Error adding document", e);
                        System.out.println("Worked");
                    }
                });
    }

    public User getDBUser(){
        DocumentReference docRef = db.collection("Users").document(mAuth.getCurrentUser().getEmail());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("", "DocumentSnapshot data: " + document.getData());
                        User u = document.toObject(User.class);
                        setUser(u);
                    } else {
                        Log.d("", "No such document");
                    }
                } else {
                    Log.d("", "get failed with ", task.getException());
                }
            }
        });
            return getUser();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


