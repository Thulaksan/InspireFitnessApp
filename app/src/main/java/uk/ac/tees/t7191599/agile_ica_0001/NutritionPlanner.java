package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class NutritionPlanner extends AppCompatActivity {
    Button searchButton;
    EditText foodName;
    ListView listView;
    public static ArrayList displayArr;
    ArrayAdapter adapter;
    FoodSearchApi foodSearchApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_planner);

        foodName = (EditText) findViewById(R.id.foodSearchBar);
        displayArr = new ArrayList();
        searchButton = findViewById(R.id.searchButton);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, displayArr);
        listView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                foodSearchApi = new FoodSearchApi();
                foodSearchApi.setFoodName(foodName.getText().toString());
                foodSearchApi.execute();

            }
        });

    }
    }


