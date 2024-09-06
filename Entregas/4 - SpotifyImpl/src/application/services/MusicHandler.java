package application.services;

import models.Music;
import models.Playlist;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Program;

public class MusicHandler {
    public static void registerNewMusic(Scanner input, Sys system) {
        System.out.print("\nEnter music title: ");
        String title = input.nextLine();
        System.out.print("\nEnter artist: ");
        String artist = input.nextLine();
        System.out.print("\nEnter genre: ");
        String genre = input.nextLine().toUpperCase();
        System.out.print("\nEnter duration (min:sec): ");
        String duration = input.nextLine();

        Music newMusic = new Music(title, artist, genre, duration);
        try {
            system.addMusicToDatabase(newMusic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addMusicToUserPlaylist(Scanner input, Sys system, User currentUser) {


        getAvailableMusics(system);

        System.out.print("\nEnter the title of the music to be added: ");
        String musicTitle = input.nextLine().toUpperCase();
        System.out.print("\nEnter the name of the author of music to be added: ");
        String authorName = input.nextLine().toUpperCase();
        Music musicToAdd = system.findMusicByTitleAndAuthor(musicTitle, authorName);

        if (musicToAdd != null) {
            List<Playlist> playlists = system.listPlaylists(currentUser);
            if (playlists.isEmpty()) {
                System.out.println("\nYou have no playlists. Create one first.");
            } else {
                Playlist chosenPlaylist = choosePlaylist(input, playlists);
                if (chosenPlaylist != null) {
                    try {
                        system.addMusicToPlaylist(musicToAdd, chosenPlaylist);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("\nInvalid choice.");
                }
            }
        } else {
            System.out.println("\nMusic not found.");
        }
    }

    private static void getAvailableMusics(Sys system){

        System.out.println("\nAvailable musics:");
        List<Music> availableMusics = system.registeredMusics;
        for (Music music : availableMusics) {
            System.out.println(music.getName() + ", " + music.getAuthor());
        }

    }

    public static void playUserMusic(Sys system, User currentUser) {
        try {
            system.playMusic(system.listPlaylists(currentUser));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listUserPlaylists(Sys system, User currentUser) {
        List<Playlist> playlists = system.listPlaylists(currentUser);
        if (playlists.isEmpty()) {
            System.out.println("\nNo playlists found.");
        } else {
            for (Playlist p : playlists) {
                System.out.println("\nPlaylist ID: " + p.getId() + ", musics: ");
                p.displayAvailableMusics();
            }
        }
    }

    private static Playlist choosePlaylist(Scanner input, List<Playlist> playlists) {
        System.out.println("\nChoose a playlist to add:");
        for (Playlist playlist : playlists) {
            System.out.println("ID: " + playlist.getId());
        }
        int playlistChoice = Program.getUserChoice();

        for (Playlist p : playlists) {
            if (playlistChoice == p.getId()) {
                return p;
            }
        }

        return null;
    }
}