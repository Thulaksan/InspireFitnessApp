package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class First_loginActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;


    ImageView propic;
    EditText et_First_Name,et_Second_Name,et_Height,et_Weight;
    TextView et_DoB;
    Uri ImageUri;
    String ImageName;
    int TempDay;
    int TempMonth;
    int TempYear;
    Calendar cal;
    private DatePickerDialog.OnDateSetListener dateListener;



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
        et_DoB = (TextView) findViewById(R.id.et_DoB);

        et_DoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        First_loginActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar userdate  = Calendar.getInstance();
                userdate.set(year,month+1,day);
                String pattern = "dd-MM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(userdate.getTime());

                et_DoB.setText(date);
                cal = userdate;
            }
        };
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
        Calendar UpdateDate = Calendar.getInstance();
        Calendar DoB = cal;
        String Email = user.getEmail();
        ImageName = Firebase.UploadImage(ImageUri);
        String H = et_Height.getText().toString().trim();
        String W = et_Weight.getText().toString().trim();


        if (FirstName ==null) {
            et_First_Name.setError("This Cant be Empty");
            et_First_Name.requestFocus();
            return;
        }
        if (SecondName ==null) {
            et_Second_Name.setError("This Cant be Empty");
            et_Second_Name.requestFocus();
            return;
        }
        if (H ==null) {
            et_Height.setError("This Cant be Empty");
            et_Height.requestFocus();
            return;
        }
        if (W ==null) {
            et_Weight.setError("This Cant be Empty");
            et_Weight.requestFocus();
            return;
        }
        if ( DoB==null) {
            et_DoB.setError("This Cant be Empty,Click Text to Add Date of Birth");
            et_DoB.requestFocus();
            return;
        }
        Double Height =Double.parseDouble(H);
        Double Weight =Double.parseDouble(W);

        User TempUser = new User(FirstName,SecondName,Email,Height,Weight,DoB.getTimeInMillis(),ImageName,UpdateDate.getTimeInMillis());

        Firebase.DBUser(TempUser);
        Intent intent = new Intent(First_loginActivity.this, EventListActivity.class);

        intent.putExtra("User",TempUser);
        startActivity(intent);


    }


}
