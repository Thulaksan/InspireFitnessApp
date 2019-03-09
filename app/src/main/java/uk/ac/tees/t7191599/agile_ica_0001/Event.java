package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

/**
 * Created by Powerman984 on 27/02/2019.
 */

public class Event implements Serializable {
    private String Name;
    private String date;

    public Event(String name, String date) {
        Name = name;
        this.date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
