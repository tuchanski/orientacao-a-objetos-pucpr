package application.services;

import models.Music;
import models.Player;
import models.Playlist;
import models.User;
import models.exceptions.AlreadyRegisteredMusicException;
import models.exceptions.AlreadyRegisteredUserException;
import models.exceptions.NonRegisteredMusicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sys {

    private static final Scanner input = new Scanner(System.in);

    // Works like a DB table
    public List<User> registeredUsers = new ArrayList<>();
    public List<Playlist> registeredPlaylists = new ArrayList<>();
    public List<Music> registeredMusics = new ArrayList<>();

    public Sys() {
        System.out.println("Initializing System...");
        try {
            iniatilizeDatabase();
        } catch (AlreadyRegisteredMusicException e){
            System.out.println("Error initializing System info.");
        }
    }

    // Display menu methods

    public void displayLoginMenu(){
        System.out.println(
                """
                        \n- Spotify Implementation -
                        [1] - Register new User
                        [2] - Log-in
                        [0] - Exit""");
    }

    public void displayUserMenu(){
        System.out.println(
                """
                        \n[1] - Register new Music
                        [2] - Create Playlist
                        [3] - Add music to Playlist
                        [4] - Play Now
                        [5] - List Playlists
                        [0] - Exit""");
    }

    public Music findMusicByTitle(String title){
        for (Music m : this.registeredMusics){
            if (m.getName().equals(title)){
                return m;
            }
        }
        return null;
    }

    public User findUserByUsernameAndPassword(String username, String password){
        for (User u : this.registeredUsers){
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    public void addNewUserToDatabase(User user) throws AlreadyRegisteredUserException {
        for (User u : registeredUsers){
            if (u.getUsername().equals(user.getUsername())){
                throw new AlreadyRegisteredUserException("User is already registered in System.");
            }
        }
        registeredUsers.add(user);
    }

    // Music related methods

    public void addMusicToDatabase(Music music) throws AlreadyRegisteredUserException {
        for (Music m : registeredMusics){
            if (m.getId().equals(music.getId())){
                throw new AlreadyRegisteredUserException("Music is already registered in System.");
            }
            if (m.getName().equals(music.getName()) && m.getAuthor().equals(music.getAuthor())){
                throw new AlreadyRegisteredUserException("Music is already registered in System.");
            }
        }
        registeredMusics.add(music);
    }

    public void addMusicToPlaylist(Music music, Playlist playlist) throws AlreadyRegisteredMusicException {
        playlist.addMusic(music);
    }

    public void createPlaylist(User user){
        Playlist newPlaylist = new Playlist(user);
        registeredPlaylists.add(newPlaylist);
    }

    public List<Playlist> listPlaylists(User user){
        List<Playlist> userPlaylists = new ArrayList<>();

        for (Playlist playlist : registeredPlaylists){
            if (playlist.getUser().equals(user)){
                userPlaylists.add(playlist);
            }
        }

        return userPlaylists;
    }

    public void playMusic(List<Playlist> availablePlaylists) throws NonRegisteredMusicException {

        Playlist chosenPlaylist = null;

        for (Playlist p : availablePlaylists){
            System.out.println("ID: " + p.getId() + ", musics: " + p.getMusics());
        }
        System.out.print("\nChoose by ID: ");
        long chosenId = input.nextLong();

        for (Playlist p : availablePlaylists){
            if (p.getId().equals(chosenId)){
                chosenPlaylist = p;
            }
        }

        if (chosenPlaylist != null){
            Player player = new Player(chosenPlaylist);
            player.startPlayer();
        }

    }

    private void iniatilizeDatabase() throws AlreadyRegisteredMusicException {

        User user1 = new User("trguilherm", "pass123");
        User user2 = new User("marinadelara", "pass321");

        this.registeredUsers.add(user1);
        this.registeredUsers.add(user2);

        Playlist playlist1 = new Playlist(user1);
        Playlist playlist2 = new Playlist(user2);

        this.registeredPlaylists.add(playlist1);
        this.registeredPlaylists.add(playlist2);

        Music music1 = new Music("Fake Plastic Trees", "Radiohead", "ROCK", "4:50");
        Music music2 = new Music("Selfless", "The Strokes", "ROCK", "3:42");

        this.registeredMusics.add(music1);
        this.registeredMusics.add(music2);

        try {
            playlist1.addMusic(music1);
            playlist1.addMusic(music2);

            playlist2.addMusic(music1);
            playlist2.addMusic(music2);
        } catch (AlreadyRegisteredMusicException e) {
            System.out.println(e.getMessage());
        }

    }
}
