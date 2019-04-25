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
    private MealPlannerEvent meal;
    private GymEvent gymEvent;

    public Event() {

    }

    public Event(String name, Long date) {
        Name = name;
        this.date = date;
    }

    public Event(String name, Long date, MealPlannerEvent meal, GymEvent gymEvent) {
        Name = name;
        this.date = date;
        this.meal = meal;
        this.gymEvent = gymEvent;
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

    public void setDate(Long date) {
        this.date = date;
    }

    public MealPlannerEvent getMeal() {
        return meal;
    }

    public void setMeal(MealPlannerEvent meal) {
        this.meal = meal;
    }

    public GymEvent getGymEvent() {
        return gymEvent;
    }

    public void setGymEvent(GymEvent gymEvent) {
        this.gymEvent = gymEvent;
    }
}
