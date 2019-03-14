package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class Body_Details implements Serializable {


    private String Height;
    private String Weight;
    private Long DOB;

    public Body_Details(String height, String weight, Long DOB) {
        Height = height;
        Weight = weight;
        this.DOB =  DOB;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public Long getDOB() {

        return this.DOB;
    }

    public void setDOB(Long DOB) {
        this.DOB = DOB;
    }

    public Body_Details() {

    }
}
