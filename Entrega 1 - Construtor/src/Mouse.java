package src;

public class Mouse {

    private String brand;
    private String model;
    private String sensor;
    private String color;
    private Boolean turnedOn;
    
    public Mouse(){
        // Strings are automatically null
    }

    public Mouse(String brand, String model, String sensor, String color) {
        this.brand = brand;
        this.model = model;
        this.sensor = sensor;
        this.color = color;
        this.turnedOn = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(Boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public void turnOn(){
        System.out.println("The mouse is turned on!");
        this.turnedOn = true;
    }

    public void turnOff(){
        System.out.println("The mouse is turned off!");
        this.turnedOn = false;
    }

    public void click(){
        System.out.println("CLICK!");
    }

    @Override
    public String toString() {
        return "Mouse [brand=" + brand + ", model=" + model + ", sensor=" + sensor + ", color=" + color + ", turnedOn="
                + turnedOn + "]";
    }

}