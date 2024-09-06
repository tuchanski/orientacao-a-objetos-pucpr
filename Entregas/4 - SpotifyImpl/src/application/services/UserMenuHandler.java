package application.services;

import models.User;

import java.util.Scanner;

import application.Program;

public class UserMenuHandler {
    public static void handleUserMenu(Scanner input, Sys system, User currentUser) {
        boolean userMenuExit = false;
        while (!userMenuExit) {
            system.displayUserMenu();
            int userChoice = Program.getUserChoice();

            switch (userChoice) {
                case 1 -> MusicHandler.registerNewMusic(input, system);
                case 2 -> system.createPlaylist(currentUser);
                case 3 -> MusicHandler.addMusicToUserPlaylist(input, system, currentUser);
                case 4 -> MusicHandler.playUserMusic(system, currentUser);
                case 5 -> MusicHandler.listUserPlaylists(system, currentUser);
                case 0 -> userMenuExit = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }
}