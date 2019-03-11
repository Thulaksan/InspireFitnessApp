package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class First_loginActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;


    ImageView propic;
    EditText et_First_Name,et_Second_Name,et_DoB;
    EditText et_Height,et_Weight;
    Uri ImageUri;
    String ImageName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login);
        propic = findViewById(R.id.propic);
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            ImageUri = data.getData();
            propic.setImageURI(ImageUri);
            //ImageName = System.currentTimeMillis()+"."+getFileExtension(ImageUri);
            String ImageName =Firebase.UploadImage(ImageUri);

        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
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

        User TempUser = new User(FirstName,SecondName,Email,Height,Weight,DoB,ImageName);
        Firebase.DBUser(TempUser);
        Intent intent = new Intent(First_loginActivity.this, EventListActivity.class);
        intent.putExtra("User",TempUser);
        startActivity(intent);
        System.out.println("Complete");
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

    }


}
