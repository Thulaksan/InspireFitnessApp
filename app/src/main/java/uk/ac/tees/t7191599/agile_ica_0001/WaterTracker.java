package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class WaterTracker implements Serializable {

    public int getWaterAmount() {
        return WaterAmount;
    }

    public void setWaterAmount(int waterAmount) {
        WaterAmount = waterAmount;
    }

    public Long getDate() {
        return Date;
    }

    public void setDate(Long date) {
        Date = date;
    }

    private int WaterAmount;
    private Long Date;


    public WaterTracker(int Water, Long date) {
        this.Date = date;
        this.WaterAmount = Water;
    }
}

