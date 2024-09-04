package models;

import java.util.ArrayList;
import java.util.List;

import models.exceptions.AlreadyRegisteredMusicException;
import models.exceptions.NonRegisteredMusicException;

public class Playlist {

    private static Long idCounter = 0L;

    private Long id;
    private List<Music> musics;
    private User user;

    public Playlist(User user){
        idCounter++;
        this.id = idCounter;
        this.user = user;
        this.musics = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void addMusic(Music music) throws AlreadyRegisteredMusicException {
        for (Music m : this.musics){
            if (m.getId().equals(music.getId())){
                throw new AlreadyRegisteredMusicException("Music already registered.");
            }
        }
        this.musics.add(music);
        System.out.println("Music " + music.getName() + " registered in Playlist with ID" + this.id + " successfully.");
    }

    public void removeMusic(Music music) throws NonRegisteredMusicException {
        for (Music m : this.musics){
            if (m.getId().equals(music.getId())){
                this.musics.remove(music);
                System.out.println("Music " + music.getName() + " removed in Playlist with ID " + this.id + " successfully.");
            }
        }
        throw new NonRegisteredMusicException("Music not found in Playlist with ID " + this.id + ".");
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + ", musics=" + musics + ", user=" + user + "]";
    }

}
