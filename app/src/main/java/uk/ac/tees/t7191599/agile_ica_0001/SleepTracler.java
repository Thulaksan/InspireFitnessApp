package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class SleepTracler implements Serializable {

    private int SleepAmount;
    private long date;

    public int getSleepAmount() {
        return SleepAmount;
    }

    public void setSleepAmount(int sleepAmount) {
        SleepAmount = sleepAmount;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public SleepTracler(int Sleep, Long date) {
        this.date = date;
        this.SleepAmount = Sleep;
    }

}

