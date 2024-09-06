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
        System.out.println("\nPlaying: " + music.getName() + " [" + music.getTime().toMinutes() + ":" + music.getTime().toSecondsPart() + "]");
        Duration musicDuration = music.getTime();
        playMusic(musicDuration);
    }

    private static void playMusic(Duration time) {
        while (!time.isZero() && !time.isNegative()) {
            try {
                status = MusicStatus.PLAYING;
                Thread.sleep(1000);
                System.out.println("Playing... [" + time.toMinutes()+ ":" + time.toSecondsPart() + "]");
                // 1 min per second!
                time = time.minus(Duration.ofSeconds(60));
            } catch (InterruptedException e) {
                status = MusicStatus.PAUSED;
                System.out.println("The music has been stopped.");
                return;
            }
        }

        System.out.println("\nThe music has been finished.");
        status = MusicStatus.IDLE;
    }
}
