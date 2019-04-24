package uk.ac.tees.t7191599.agile_ica_0001;

public class GymPlace {


    String Name;
    Double lng;
    Double lat;


    public GymPlace(String name, Double lng, Double lat) {
        Name = name;
        this.lng = lng;
        this.lat = lat;
    }

    public String getName() {
        return Name;
    }

    public Double getLng() {
        return lng;
    }

    public Double getLat() {
        return lat;
    }
}
