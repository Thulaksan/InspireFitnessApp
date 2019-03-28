package uk.ac.tees.t7191599.agile_ica_0001;

import java.io.Serializable;

public class Body_Details implements Serializable {


    private Double Height;
    private Double Weight;
    private Long Date;
    private Double BMI;
    private String BMIStat;

    public Body_Details(Double height, Double weight, Long Date) {
        this.Height = height; //M
        this.Weight = weight; //Kg
        this.Date =  Date;
        this.BMI = Weight/(Height* Height);

        if(BMI>30){
            this.BMIStat ="obese";
        }else if(BMI<29.99 && BMI>25){
            this.BMIStat ="overweight";
        } else if(BMI<24.99 && BMI>18.5){
            this.BMIStat ="healthy";
        }else if(BMI<18.5 ){
            this.BMIStat ="underweight";
        }

    }
    public Double getHeight() {
        return Height;
    }
    public void setHeight(Double height) {
        Height = height;
    }
    public Double getWeight() {
        return Weight;
    }
    public void setWeight(Double weight) {
        Weight = weight;
    }
    public void setDate(Long date) {
        Date = date;
    }
    public Double getBMI() {
        return BMI;
    }
    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }
    public Body_Details() {

    }
}
