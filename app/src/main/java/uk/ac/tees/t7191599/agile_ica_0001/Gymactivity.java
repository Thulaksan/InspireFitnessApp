package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Gymactivity extends AppCompatActivity {
    User u;
    Spinner GymEvents;
    Spinner Rep ;
    TextView tv_Date;
    Calendar c;
    private DatePickerDialog.OnDateSetListener dateListener;
    private ArrayList< WorkOut > EventList = new ArrayList< WorkOut >();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        u = (User) getIntent().getSerializableExtra("User");
        setContentView(R.layout.activity_gymactivity);
        populateSpinners();
        populateDate();
        populateScroller(u);

    }

    private void populateDate(){
        tv_Date = findViewById(R.id.tv_Date);
        tv_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Gymactivity.this,
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
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                 c = Calendar.getInstance();
                       c.set(year,month,day);
                tv_Date.setText(date);
            }
        };
    }
    private void populateScroller(User u
    ){

        GymEvent gEvent = (GymEvent) getIntent().getSerializableExtra("position");
        if (gEvent != null)
        {
            EventList = gEvent.getWorkOuts();
        }

        ArrayList< String > ListViewEvents = new ArrayList< String >();
        for (WorkOut item: EventList) {
            String  x = item.getExersize().toString() +" x" +item.getReps();
            ListViewEvents.add(x);
        }

        ListAdapter LA = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ListViewEvents);
        ListView Scroll = (ListView) findViewById(R.id.Scroll);
        Scroll.setAdapter(LA);


    }
    private void populateSpinners(){

        GymEvents = findViewById(R.id.Spinner_type);
        Rep = findViewById(R.id.Spinner_Rep);
        List< String > list = new ArrayList< String >();
        list.add("Crunch Resisted Crunch");
        list.add("Inclined Crunch with Feet Attached Crunch with Leg Curl");
        list.add("Sit-Up with Feet Attached Sit-Up with Cable");
        list.add("Trunk Rotation Jacknife Sit-Up");
        list.add("High Leg Pull-In Low Leg Pull-In");
        list.add("Side Plank Hyperextension");
        list.add("VCrossover Row");
        list.add("Row with Hyperextension Back Fly");
        list.add("Rotating Back Fly Prone Back Fly");
        list.add("Back Fly with Leg Curl Lateral Pulldown");
        list.add("Pulldown with Squat with Elbows Flexed Lateral Pulldown with Squat");
        list.add("Pull-Up Chest Press");
        list.add("Close-Grip Chest Press Wide-Grip Chest Press");
        list.add("Incline Push Up Chest Fly");
        list.add("Incline Chest Fly Decline Chest Fly");
        list.add("Lateral Chest Fly Pullover");
        list.add("Pullover with Crunch Pullover with Twisting Crunch");
        list.add("Pullover with Squat Single Leg Pullover with Squat");
        list.add("Leg Curl Reverse Leg Curl");
        list.add("Squat Wide Squat");
        list.add("Single-Leg Squat Single-Leg Squat On Side");
        list.add("Single-Leg Squat Kneeling Jumping Squat");
        list.add("Twisting Squat Jumping and Twisting Squat");
        list.add("Front Lunge Hip Extension with Knee Stabilized");
        list.add("Hip Abduction Hip Adduction");
        list.add("Calf Raise Biceps Curl");
        list.add("Lateral Single-Arm Biceps Curl Lying Biceps Curl");
        list.add("Biceps Curl with Crunching Biceps Curl with Hyperextension");
        list.add("Biceps Curl with Leg Curl Chin-Up");
        list.add("Triceps Extension Prone Triceps Extension");
        list.add("Kneeling Triceps Extension Lateral Single-Arm Triceps Extension");
        list.add("Lateral Single-Arm Triceps Extension");
        list.add("Row");
        list.add("Kneeling Row");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GymEvents.setAdapter(dataAdapter);

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        list1.add(11);
        list1.add(12);
        list1.add(13);
        list1.add(14);
        list1.add(15);
        list1.add(16);
        list1.add(17);
        list1.add(18);
        list1.add(19);
        list1.add(20);

        ArrayAdapter<Integer> dataAdapter2 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Rep.setAdapter(dataAdapter2);



    }

    public void AddEvent(View view){
        Long Date =c.getTimeInMillis();

        Event l = new Event("gym activity", Date);
        l.setGymEvent(new GymEvent(EventList));


        u.getEvents().add(l);
        Firebase f = new Firebase();
        f.DBUser(u);
        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("User",u);
        startActivity(intent);

    }

    public void AddItemEvent(View view){

        String EventName = GymEvents.getItemAtPosition(GymEvents.getSelectedItemPosition()).toString();
        int Amount = (Integer) Rep.getItemAtPosition(Rep.getSelectedItemPosition());
        EventList.add(new WorkOut(EventName,Amount));
        populateScroller(u);
    }

    public void SaveAs(View view){
        u.setCommonWorkOut(EventList);

    }
    public void LoadAs(View view){
        EventList= u.getCommonWorkOut();


    }




}
