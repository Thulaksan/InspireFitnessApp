package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class SleepTracler extends Event implements Serializable {

    private int SleepAmount;

    public SleepTracler(int Sleep, Long date) {
        super("Sleep Update", date, new MealPlannerEvent());
        this.SleepAmount = Sleep;
    }

}

