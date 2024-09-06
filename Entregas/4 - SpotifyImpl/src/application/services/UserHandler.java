package application.services;

import models.User;
import java.util.Scanner;

public class UserHandler {
    public static void registerNewUser(Scanner input, Sys system) {
        System.out.print("\nEnter username: ");
        String username = input.nextLine().toLowerCase();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        try {
            User newUser = new User(username, password);
            system.addNewUserToDatabase(newUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loginUser(Scanner input, Sys system) {
        System.out.print("\nEnter username: ");
        String username = input.nextLine().toLowerCase();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        User currentUser = system.findUserByUsernameAndPassword(username, password);

        if (currentUser != null) {
            System.out.println("\nLogin successful.");
            System.out.println("\nHello, " + username);
            UserMenuHandler.handleUserMenu(input, system, currentUser);
        } else {
            System.out.println("\nIncorrect username or password.");
        }
    }
}
