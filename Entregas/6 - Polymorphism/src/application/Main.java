package application;

import models.*;

public class Main {
    public static void main(String[] args) {

        Animal dog = new Dog("Peppa", 5, 20.0, "Corgi");
        Animal cat = new Cat("Luna", 3, 4.5, "Orange");
        Animal horse = new Horse("Manda-chuva", 8, 500.0, 60.0);

        if (dog instanceof Dog) {
            ((Dog) dog).wagTail();
        }

        if (cat instanceof Cat) {
            ((Cat) cat).scratch();
        }

        if (horse instanceof Horse) {
            ((Horse) horse).gallop();
        }

        callPolymorphicSound(dog);
        callPolymorphicSound(cat);
        callPolymorphicSound(horse);
    }

    public static void callPolymorphicSound(Animal animal) {
        animal.makeSound();
    }
}
