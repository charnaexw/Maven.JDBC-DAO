package models;

public class Car {
    private Long id;
    private String make;
    private String model;
    private String color;
    private Long vin;

    public Car(){
    }

    public Car(Long id, String make, String model, String color, Long vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.vin = vin;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getVin() {
        return vin;
    }

    public void setVin(Long vin) {
        this.vin = vin;
    }

    @Override
    public String toString(){
        return "Car {" +
                "id=" + id +
                ", make =" + make +
                ", model =" + model +
                ", color =" + color +
                ", vin =" + vin +"}";
    }
//    @Override
//    public String toString() {
//        return "Artist {" +
//                "ID = " + id +
//                ", Name = " + name +
//                ", Birth Place = " + birthPlace +
//                ", Birth Year = " + birthYear +
//                "}";
//    }
}
