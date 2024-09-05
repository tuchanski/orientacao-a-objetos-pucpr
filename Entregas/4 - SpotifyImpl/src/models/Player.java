package models;

import java.time.Duration;

import models.exceptions.NonRegisteredMusicException;

public class Player {

    private Playlist inQueue;

    public Player(Playlist inQueue) {
        this.inQueue = inQueue;
    }
    
    public void startPlayer() throws NonRegisteredMusicException {

        if (this.inQueue.getMusics().isEmpty()) {
            throw new NonRegisteredMusicException("The playlist is empty.");
        }

        for (Music m : this.inQueue.getMusics()) {
            startMusic(m);
        }
    }

    public void startMusic(Music music) {
        System.out.println("Playing: " + music.getName());
        Duration musicDuration = music.getTime();
        playMusic(musicDuration);
    }

    private static void playMusic(Duration time) {
        while (!time.isZero()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("The music has been stopped.");
                return;
            }
            System.out.print(time.toSeconds() + "sec... ");
            time = time.minus(Duration.ofSeconds(1));
        }
        
        if (time.isZero()){
            System.out.println("\nThe music has been finished.");
        }
    }
}
