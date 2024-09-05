package models;

import java.time.Duration;

import models.enums.MusicStatus;
import models.exceptions.NonRegisteredMusicException;

public class Player {

    private static MusicStatus status = MusicStatus.IDLE;
    private Playlist inQueue;

    public Player(Playlist inQueue) {
        this.inQueue = inQueue;
    }

    public MusicStatus getStatus() {
        return status;
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
                status = MusicStatus.PLAYING;
                Thread.sleep(1000);
                System.out.print(time.toSeconds() + "sec... ");
                time = time.minus(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                status = MusicStatus.PAUSED;
                System.out.println("The music has been stopped.");
                return;
            }
        }

        if (time.isZero()) {
            System.out.println("\nThe music has been finished.");
            status = MusicStatus.IDLE;
        }
    }
}
