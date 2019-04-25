package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by t7207089 on 02/04/19.
 */

public class MealPlannerEvent implements Serializable {

    private ArrayList<String> displayArr;
    private List<Integer> kCalArray;

    public MealPlannerEvent() {
    }

    public MealPlannerEvent(ArrayList displayArr, List<Integer> kCalArray) {
        this.displayArr = displayArr;
        this.kCalArray = kCalArray;
    }


    public ArrayList<String> getDisplayArr() {
        return displayArr;
    }

    public void setDisplayArr(ArrayList<String> displayArr) {
        this.displayArr = displayArr;
    }

    public List<Integer> getkCalArray() {
        return kCalArray;
    }

    public void setkCalArray(List<Integer> kCalArray) {
        this.kCalArray = kCalArray;
    }
}