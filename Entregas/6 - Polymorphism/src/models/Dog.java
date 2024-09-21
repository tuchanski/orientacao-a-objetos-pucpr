package models;

public class Dog extends Animal {

    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is barking.");
    }

    public void wagTail() {
        System.out.println(name + " is wagging its tail.");
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + ", breed=" + breed + ", age=" + age + ", weight=" + weight + "]";
    }

}