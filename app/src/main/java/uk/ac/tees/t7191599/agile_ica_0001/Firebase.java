package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.Serializable;

public class Firebase implements Serializable {


    private FirebaseAuth mAuth= FirebaseAuth.getInstance();
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseFirestoreSettings settings;
    static Long x = System.currentTimeMillis();
    static FirebaseStorage storage = FirebaseStorage.getInstance();
    private static StorageReference ImageStorage = storage.getReference(x.toString());
    private Firebase fb;
    private Activity act;
    private User user;
    private static String ImageURL;



    public Firebase getFb() {
        return fb;
    }

    public void setFb(Firebase fb) {
        this.fb = fb;
    }




    public Firebase() {
        //initializes Firebase Settings
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .build();
        db.setFirestoreSettings(settings);


    }

    public FirebaseAuth getmAuth() {

        return mAuth;
    }
    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    public void SignUp(String Email, String Password) {

        setFb(this);
        // Creates Firebase Authentications User with given username and pass
        getmAuth().createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getAct(), "Registered", Toast.LENGTH_SHORT).show();
                    // Assigns created user to the FirebaseUser Variable
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

        //Gets Firebase Authentication user with provided email and password,
        getmAuth().signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // Assigns created user to the FirebaseUser Variable
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String Email = user.getEmail();
                    // gets Firebase document which matches firebase Auth Email address
                    getDBUser(Email);


                } else {
                    Toast.makeText(getAct(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public static String UploadImage(Uri image) {

        // attempts to place a image in the root directly of firebase storage,
        ImageStorage.putFile(image).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>()
        {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception
            {
                //error management
                if (!task.isSuccessful())
                {
                    throw task.getException();
                }

                return ImageStorage.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>()
        {
            @Override
            public void onComplete(@NonNull Task<Uri> task)
            {
                if (task.isSuccessful())
                {
                    //gets URl for saved imaged
                    Uri downloadUri = task.getResult();

                    //waits for the Async task to finish
                    while((downloadUri.toString()==null)){
                    downloadUri = task.getResult();
                }

                    // Assigns URl to var to get around inner class issues
                    setImageURL(downloadUri.toString());

                }
            }
        });

        // gets and returns to get around inner class issues
    return getImageURL();
    }

    public static String getImageURL() {
        return ImageURL;
    }

    public static void setImageURL(String imageURL) {
        ImageURL = imageURL;
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

    public void getDBUser(String Email){
        DocumentReference docRef = db.collection("Users").document(Email);
        Task<DocumentSnapshot> task = docRef.get();

        task.addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()) {
                    user = task.getResult().toObject(User.class);

                    //Log.d("Test", user.);
                    Intent intent = new Intent(getAct(), EventListActivity.class);
                    // adds user to intent , this allows user to be passed from one activity to the next
                    intent.putExtra("User",user);
                    //starts next activity
                    getAct().startActivity(intent);
                }
            }
        });
//    while (task.isSuccessful() !=true){
//    }
//        User u = task.getResult().toObject(User.class);
//        System.out.println(u.getFirst_Name());
//
//  return u;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


