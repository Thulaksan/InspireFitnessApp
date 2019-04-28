package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by t7066356 on 15/02/19.
 */

public class User implements Serializable {
     private String First_Name;
     private String Second_Name;
     private String Image;
    private String Email;
    private Long DoB;
     private Body_Details Current;
    private  ArrayList<Body_Details> BodyHistory = new ArrayList<Body_Details>();

    public ArrayList<SleepTracler> getSleep() {
        return Sleep;
    }

    public void setSleep(ArrayList<SleepTracler> sleep) {
        Sleep = sleep;
    }

    public ArrayList<WaterTracker> getWater() {
        return Water;
    }

    public void setWater(ArrayList<WaterTracker> water) {
        Water = water;
    }

    private ArrayList<Event> Events = new ArrayList<Event>();
    private ArrayList< SleepTracler > Sleep = new ArrayList<SleepTracler  >();
    private ArrayList< WaterTracker > Water = new ArrayList< WaterTracker >();
    private ArrayList< WorkOut > CommonWorkOut = new ArrayList< WorkOut >();

    public ArrayList< WorkOut >  getCommonWorkOut() {
        return CommonWorkOut;
    }

    public void setCommonWorkOut(ArrayList< WorkOut >  commonWorkOut) {
        CommonWorkOut = commonWorkOut;
    }

    public Long getDoB() {
        return DoB;
    }

    public void setDoB(Long doB) {
        DoB = doB;
    }


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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
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

    public User(String first_Name, String second_Name, String email, Double height, Double weight, Long DOB, String image,Long Date) {
        this.First_Name = first_Name;
        this.Second_Name = second_Name;
        this. Email = email;
        this. Current = new Body_Details(height,weight,Date);
        this.BodyHistory.add(Current);
        this.Image = image;
        this.DoB= DOB;

    }
}
