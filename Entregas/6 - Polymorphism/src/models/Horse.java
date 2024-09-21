package models;

public class Horse extends Animal {
    private double speed;

    public Horse(String name, int age, double weight, double speed) {
        super(name, age, weight);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is neighing.");
    }

    public void gallop() {
        System.out.println(name + " is galloping at " + speed + " km/h.");
    }

}