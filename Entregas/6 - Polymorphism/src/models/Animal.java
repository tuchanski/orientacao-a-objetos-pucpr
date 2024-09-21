package models;

public class Animal {

    protected String name;
    protected int age;
    protected double weight;

    public Animal() {
        this.name = "Unknown";
        this.age = 0;
        this.weight = 0.0;
    }

    public Animal(String nome, int idade, double peso) {
        this.name = nome;
        this.age = idade;
        this.weight = peso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void comer() {
        System.out.println(name + " is eating.");
    }

    public void makeSound() {
        System.out.println(name + " is making a sound.");
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", weight=" + weight + "]";
    }

}
