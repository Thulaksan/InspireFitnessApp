package uk.ac.tees.t7191599.agile_ica_0001;

/**
 * Created by t7066356 on 15/02/19.
 */

public class User {
    String First_Name;
    String Second_Name;
    String Email;
    String Password;


    // Blank Constructor Required For Firebase
    public User() {}

    public User(String first_Name, String second_Name, String email, String password) {
        First_Name = first_Name;
        Second_Name = second_Name;
        Email = email;
        Password = password;
    }

    // Getters And Setters
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
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    }
