package uk.ac.tees.t7191599.agile_ica_0001;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class GetGyms extends AsyncTask<Object,String,String> {
    private String Url;
    private GoogleMap mMap;
    ArrayList<GymPlace> MapPlaces;


    @Override
    protected String doInBackground(Object... objects)
    {


        mMap = (GoogleMap) objects[0];
        Url = (String) objects[1];
        MapPlaces = Parse(Url);
        return null;
    }


    @Override
    protected void onPostExecute(String s)
    {

        DisplayNearbyPlaces(MapPlaces);
    }


    private void DisplayNearbyPlaces(ArrayList<GymPlace> Places)
    {
        for (GymPlace p : Places)
        {
            MarkerOptions markerOptions = new MarkerOptions();
            String nameOfPlace =  p.getName();
            double lat = p.getLat();
            double lng = p.getLng();


            LatLng latLng = new LatLng(lat, lng);
            markerOptions.position(latLng);
            markerOptions.title(nameOfPlace);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        }
    }

    public ArrayList<GymPlace> Parse(String Data){

        ArrayList<GymPlace> Places = new ArrayList<GymPlace>();
        try {

            JSONObject JObject = Url_Json(Data);
            JSONArray JArray = (JSONArray) JObject.get("results");
            for (int i=0; i <= JArray.length()-1; i++){
                JSONObject Temp = (JSONObject) JArray.get(i);
                String Name =  Temp.getString("name");
                Double lat = (Double) Temp.getJSONObject("geometry").getJSONObject("location").get("lat");
                Double Long = (Double) Temp.getJSONObject("geometry").getJSONObject("location").get("lng");
                Places.add(new GymPlace(Name,Long,lat));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Places;
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject Url_Json(String url) throws IOException, JSONException {
        System.out.println(url);
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }



}