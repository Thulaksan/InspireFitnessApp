package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class WaterTracker extends Event implements Serializable {

    private int WaterAmount;

    public WaterTracker(int Water, Long date) {
        super("Water Update", date);
        this.WaterAmount = Water;
    }
}

