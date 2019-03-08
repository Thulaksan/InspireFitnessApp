package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by t7066356 on 15/02/19.
 */

public class User implements Serializable {
    String First_Name;
    String Second_Name;
    String Email;
    Body_Details Current;
    ArrayList<Body_Details> BodyHistory = new ArrayList<Body_Details>();
    ArrayList<Event> Events = new ArrayList<Event>();




    // Blank Constructor Required For Firebase
    public User() {
    }

    public User(String first_Name, String second_Name, String email, String height, String weight, String DOB) {
        First_Name = first_Name;
        Second_Name = second_Name;
        Email = email;
        Current = new Body_Details(height,weight,DOB);
        BodyHistory.add(Current);

    }
}
