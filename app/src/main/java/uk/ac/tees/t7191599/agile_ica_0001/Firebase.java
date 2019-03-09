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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.SetOptions;

import java.io.Serializable;

public class Firebase implements Serializable {


    private FirebaseAuth mAuth;
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseFirestoreSettings settings;
    private Activity act;
    private User user;

    public Firebase getFb() {
        return fb;
    }

    public void setFb(Firebase fb) {
        this.fb = fb;
    }

    private Firebase fb;


    public Firebase() {

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);


    }

    public FirebaseAuth getmAuth() {
        setmAuth(FirebaseAuth.getInstance());
        return mAuth;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    public void SignUp(String Email, String Password) {

        setFb(this);

        getmAuth().createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getAct(), "Registered", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    Intent intent = new Intent(getAct(), First_loginActivity.class);
                    intent.putExtra("Auth",user);
                    getAct().startActivity(intent);
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

        getmAuth().signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String Email = user.getEmail();

                    User u = getDBUser(Email);

                    Intent intent = new Intent(getAct(), EventListActivity.class);
                    intent.putExtra("User",u);
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

    public static void DBUser(User Temp){

        db.collection("Users").document(Temp.getEmail())
                .set(Temp, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Signup", "Error adding document", e);
                        System.out.println("Worked");
                    }
                });
    }

    public User getDBUser(String Email){
        DocumentReference docRef = db.collection("Users").document(Email);
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


