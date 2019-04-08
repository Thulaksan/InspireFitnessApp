package uk.ac.tees.t7191599.agile_ica_0001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NutritionPlanner extends AppCompatActivity {
    Button searchButton;
    EditText foodName;
    ListView listView;
    public static ArrayAdapter adapter;
    public static TextView kCalComparison;


    int loadId;


    public static ArrayList displayArr;
    public static List<Integer> kCalArray;

    private int reccommendedKcal = 2500;
    private int currentKcal;

    User u;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        u = (User) getIntent().getSerializableExtra("User");
        setContentView(R.layout.activity_nutrition_planner);

        loadId = getIntent().getIntExtra("position", 0);


        foodName = (EditText) findViewById(R.id.foodSearchBar);
        kCalComparison = findViewById(R.id.calorieComparison);
        searchButton = findViewById(R.id.searchButton);

         displayArr = new ArrayList();
         kCalArray = new ArrayList();

         Event hello = u.getEvents().get(loadId);

         if (hello instanceof MealPlannerEvent)
         {
             reccommendedKcal = 1000;
         }
         else
         {
             reccommendedKcal = 1;
         }

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, displayArr);

        listView.setAdapter(adapter);



        currentKcal = totalCalorie();
        kCalComparison.setText("Reccommended calorie: " + reccommendedKcal + " Current: " + currentKcal);


        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FoodSearchApi foodSearchApi = new FoodSearchApi();
                currentKcal = totalCalorie();
                foodSearchApi.setFoodName(foodName.getText().toString());
                foodSearchApi.setCals(currentKcal, reccommendedKcal);
                foodSearchApi.execute();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == position)
                {
                    displayArr.remove(position);
                    kCalArray.remove(position);
                    adapter.notifyDataSetChanged();
                    currentKcal = totalCalorie();
                    kCalComparison.setText("Reccommended calorie: " + reccommendedKcal + " Current: " + currentKcal);
                }
            }
        });
    }




    public int totalCalorie()
    {
        int numb = 0;

        if (kCalArray.isEmpty())
        {
            numb = 0;
        }
        else
        {
            for (int i = 0; i < kCalArray.size(); i++)
            {

                numb = numb + kCalArray.get(i);
            }
        }
        return numb;
    }

    public void AddEvent(View view){

        Calendar c = Calendar.getInstance();
        c.getTime();
        c.getTimeInMillis();

        Long Date =c.getTimeInMillis();

        u.getEvents().add(new MealPlannerEvent(Date,displayArr, kCalArray));
        Firebase f = new Firebase();
        f.DBUser(u);
        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("User",u);
        startActivity(intent);

    }




}


