package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;
import java.util.ArrayList;

public class GymEvent extends Event implements Serializable {

    private ArrayList<WorkOut> WorkOuts = new ArrayList<WorkOut>();


    public GymEvent() {
    }

    public GymEvent(ArrayList<WorkOut> workOuts) {
        WorkOuts = workOuts;
    }

    public ArrayList<WorkOut> getWorkOuts() {
        return WorkOuts;
    }

    public void setWorkOuts(ArrayList<WorkOut> workOuts) {
        WorkOuts = workOuts;
    }
}
