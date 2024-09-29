package src.application;

import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        Mouse mouse1 = new Mouse("Razer", "Deathadder", "Optic", "Black");

        System.out.println(mouse1);

        mouse1.turnOn();

        mouse1.click();
        mouse1.click();

        mouse1.turnOff();

        System.out.println("\n- Registering mouse 2 -");
        System.out.print("\nEnter a brand: ");
        String brand = input.next();
        System.out.print("\nEnter a model: ");
        String model = input.next();
        System.out.print("\nEnter a sensor: ");
        String sensor = input.next();
        System.out.print("\nEnter a color: ");
        String color = input.next();

        Mouse mouse2 = new Mouse(brand, model, sensor, color);

        System.out.println("\nMouse 2 brand: " + mouse2.getBrand());
        System.out.println("Mouse 2 color: " + mouse2.getColor());

        mouse2.click();

        input.close();

    }
    
}
