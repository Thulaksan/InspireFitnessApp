package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class WorkOut implements Serializable {

    String Exersize;
    int Reps;

    public WorkOut(String exersize, int reps) {
        Exersize = exersize;
        Reps = reps;
    }
}
