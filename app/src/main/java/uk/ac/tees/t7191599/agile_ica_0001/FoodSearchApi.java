package uk.ac.tees.t7191599.agile_ica_0001;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by t7207089 on 27/02/19.
 */

public class FoodSearchApi extends AsyncTask {
    StringBuilder stringBuilder = new StringBuilder();
    String searchName = "";
    String sendingData = "";
    int sendingKcal;


    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            URL food = new URL("https://api.myjson.com/bins/hvgjy");
            HttpURLConnection httpURLConnection = (HttpURLConnection) food.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String read = "";
            while (read != null)
            {
                read = bufferedReader.readLine();
                stringBuilder.append(read);
            }

            JSONArray foodItemsArr = new JSONArray(stringBuilder.toString());
            for (int i = 0; i < foodItemsArr.length(); i++)
            {
                JSONObject jO = (JSONObject) foodItemsArr.get(i);
                if (searchName.equals(jO.get("name")))
                {
                    sendingData = "food name: " + jO.get("name") + "\n" +
                            "nutritional rating: " + jO.get("nutritional rating") + "\n" +
                            "calories: " + jO.get("calories");

                    sendingKcal = Integer.parseInt("" + jO.get("calories"));
                    break;
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);


            NutritionPlanner.displayArr.add(sendingData);
            NutritionPlanner.kCalArray.add(sendingKcal);
            NutritionPlanner.adapter.notifyDataSetChanged();

    }

    public void setFoodName(String name)
    {
        searchName = name;
    }








}
