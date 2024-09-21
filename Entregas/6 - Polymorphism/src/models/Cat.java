package models;

public class Cat extends Animal {

    private String color;

    public Cat(String name, int age, double weight, String color) {
        super(name, age, weight);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is meowing.");
    }

    public void scratch() {
        System.out.println(name + " is scratching.");
    }

    @Override
    public String toString() {
        return "Cat [name=" + name + ", color=" + color + ", age=" + age + ", weight=" + weight + "]";
    }

}