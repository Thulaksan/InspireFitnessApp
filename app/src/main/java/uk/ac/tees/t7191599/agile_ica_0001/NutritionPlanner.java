package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NutritionPlanner extends AppCompatActivity {
    Button searchButton;
    EditText foodName;
    ListView listView;
    ArrayAdapter adapter;

    public static String gettingfood = "";
    public static int gettingKcal = 0;
    ArrayList displayArr;
    List<Integer> kCalArray;

    private int reccommendedKcal = 2500;
    private int currentKcal = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_planner);

        foodName = (EditText) findViewById(R.id.foodSearchBar);
        displayArr = new ArrayList();
        kCalArray = new ArrayList();
        displayArr.add("Reccommended Kcal = " + reccommendedKcal + "Current = " + totalCalorie());
        searchButton = findViewById(R.id.searchButton);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, displayArr);
        listView.setAdapter(adapter);


        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FoodSearchApi foodSearchApi = new FoodSearchApi();
                foodSearchApi.setFoodName(foodName.getText().toString());
                foodSearchApi.execute();

                if (!gettingfood.equals(""))
                {
                    displayArr.add(gettingfood);
                    kCalArray.add(gettingKcal);

                    displayArr.add(1, "Reccommended Kcal = " + reccommendedKcal + "Current = " + totalCalorie());
                    displayArr.remove(2);
                }

                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == position)
                {
                    displayArr.remove(position);
                    adapter.notifyDataSetChanged();

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



//    public void saveButton(View save)
//    {
//        String date = getCurrentTimeUsingDate();
//        MealPlannerEvent saveMeal = new MealPlannerEvent("Meal Planner", date , displayArr);
//    }
//
//    public static String getCurrentTimeUsingDate() {
//        Date date = new Date();
//        String strDateFormat = "hh:mm:ss a";
//        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
//        String formattedDate= dateFormat.format(date);
//        return formattedDate;
// }

}


