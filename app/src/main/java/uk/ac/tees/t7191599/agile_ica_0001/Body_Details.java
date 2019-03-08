package uk.ac.tees.t7191599.agile_ica_0001;

public class Body_Details {


    String Height;
    String Weight;
    String DOB;

    public Body_Details(String height, String weight, String DOB) {
        Height = height;
        Weight = weight;
        this.DOB = DOB;
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}
