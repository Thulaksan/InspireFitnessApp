package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by t7207089 on 02/04/19.
 */

public class MealPlannerEvent extends Event implements Serializable {

    private ArrayList displayArr;
    private List<Integer> kCalArray;

    public MealPlannerEvent(Long date, ArrayList displayArr, List<Integer> kCalArray) {
        super("Meal planner", date);
        this.displayArr = displayArr;
        this.kCalArray = kCalArray;
    }

    public ArrayList getDisplayArr() {
        return displayArr;
    }
}