package models;

public class Car {

    private String model;
    private String brand;
    private Integer price; // Must be saved in cents

    public Car() {
    }

    public Car(String model, String brand, Integer price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", brand=" + brand + ", price=" + price + "]";
    }

}
