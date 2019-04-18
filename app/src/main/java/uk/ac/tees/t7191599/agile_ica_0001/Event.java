package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Powerman984 on 27/02/2019.
 */

public class Event implements Serializable {
    private String Name;
    private Long date;
    private MealPlannerEvent eventsstore;

    public Event(String name, Long date, MealPlannerEvent eventsstore) {
        Name = name;
        this.date = date;
        this.eventsstore = eventsstore;
    }
    public Event() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getDate() {
        return date;
    }

    public String getDateStr() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String d = simpleDateFormat.format(c.getTime());
        return d;
    }

    public void setDate(Long date) {
        this.date = date;
    }


    public Object getEventsstore() {
        return eventsstore;
    }

    public void setEventsstore(MealPlannerEvent eventsstore) {
        this.eventsstore = eventsstore;
    }
}
