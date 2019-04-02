package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class WorkOut implements Serializable {

    private String Exersize;
    private int Reps;

    public WorkOut(String exersize, int reps) {
        Exersize = exersize;
        Reps = reps;
    }
    public WorkOut() {

    }


    public String getExersize() {
        return Exersize;
    }

    public void setExersize(String exersize) {
        Exersize = exersize;
    }

    public int getReps() {
        return Reps;
    }

    public void setReps(int reps) {
        Reps = reps;
    }


}
