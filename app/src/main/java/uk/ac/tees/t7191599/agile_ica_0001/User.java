package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by t7066356 on 15/02/19.
 */

public class User implements Serializable {
     private String First_Name;
     private String Second_Name;
    private String Email;
     private Body_Details Current;
    private  ArrayList<Body_Details> BodyHistory = new ArrayList<Body_Details>();
    private ArrayList<Event> Events = new ArrayList<Event>();


    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getSecond_Name() {
        return Second_Name;
    }

    public void setSecond_Name(String second_Name) {
        Second_Name = second_Name;
    }

    public Body_Details getCurrent() {
        return Current;
    }

    public void setCurrent(Body_Details current) {
        Current = current;
    }

    public ArrayList<Body_Details> getBodyHistory() {
        return BodyHistory;
    }

    public void setBodyHistory(ArrayList<Body_Details> bodyHistory) {
        BodyHistory = bodyHistory;
    }

    public ArrayList<Event> getEvents() {
        return Events;
    }

    public void setEvents(ArrayList<Event> events) {
        Events = events;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    // Blank Constructor Required For Firebase
    public User() {
    }

    public User(String first_Name, String second_Name,String email, String height, String weight, String DOB) {
        First_Name = first_Name;
        Second_Name = second_Name;
        Email = email;
        Current = new Body_Details(height,weight,DOB);
        BodyHistory.add(Current);

    }
}
