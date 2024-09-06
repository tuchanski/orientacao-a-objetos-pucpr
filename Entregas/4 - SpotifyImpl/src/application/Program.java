package application;

import java.util.Scanner;

import application.services.Sys;
import application.services.UserHandler;

public class Program {
    private static final Scanner input = new Scanner(System.in);
    private static final Sys system = new Sys();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            system.displayLoginMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> UserHandler.registerNewUser(input, system);
                case 2 -> UserHandler.loginUser(input, system);
                case 0 -> exit = true;
                default -> System.out.println("Invalid option.");
            }
        }
        input.close();
        System.out.println("\nProgram has been finished.");
    }

    public static int getUserChoice() {
        System.out.print("\nChoose an option: ");
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("\nInvalid choice. Try again: ");
        }
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }
}
