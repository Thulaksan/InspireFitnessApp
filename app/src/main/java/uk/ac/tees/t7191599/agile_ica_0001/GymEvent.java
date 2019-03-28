package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.util.ArrayList;

public class GymEvent extends Event implements Serializable {

    ArrayList<WorkOut> WorkOuts = new ArrayList<WorkOut>();

    public GymEvent(String date, ArrayList<WorkOut> workOuts) {
        super("Gym Workout", date);
        WorkOuts = workOuts;
    }
}