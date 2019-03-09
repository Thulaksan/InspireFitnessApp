package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class First_loginActivity extends AppCompatActivity {


    ImageView propic;
    EditText et_First_Name,et_Second_Name,et_DoB;
    EditText et_Height,et_Weight;
    Uri uriProfileImage;
    String profileImageUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login);

    }

    public void FinalLogin(View view){


        Intent i = getIntent();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();




        et_First_Name =  findViewById(R.id.et_First_Name);
        et_Second_Name =  findViewById(R.id.et_Second_Name);
        et_DoB =  findViewById(R.id.et_DoB);
        et_Height =  findViewById(R.id.et_Height);
        et_Weight =  findViewById(R.id.et_Weight);

        String FirstName = et_First_Name.getText().toString().trim();
        String SecondName = et_Second_Name.getText().toString().trim();
        String  DoB = et_DoB.getText().toString();
        String Email = user.getEmail();
        String Height = et_Height.getText().toString().trim();
        String Weight = et_Weight.getText().toString().trim();

        User TempUser = new User(FirstName,SecondName,Email,Height,Weight,DoB);
        Firebase.DBUser(TempUser);
        Intent intent = new Intent(First_loginActivity.this, EventListActivity.class);
        intent.putExtra("User",TempUser);
        startActivity(intent);
        System.out.println("Complete");
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

    }


}
