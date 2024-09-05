package models;

import java.time.Duration;

import models.enums.Author;
import models.enums.Genre;

public class Music {

    private static Long idCounter = 0L;

    private Long id;
    private String name;
    private Author author;
    private Genre genre;
    private Duration time;

    // Time in format: "m:s"
    public Music(String name, String author, String genre, String time) {
        idCounter++;
        this.id = idCounter;
        this.name = name;
        this.author = Author.valueOf(author);
        this.genre = Genre.valueOf(genre);
        this.time = convertToDuration(time);
    }

    private Duration convertToDuration(String time){
        String[] arr = time.strip().split(":");
        long minutes = Long.parseLong(arr[0]);
        long seconds = Long.parseLong(arr[1]);
        Duration timeImpl = Duration.ofMinutes(minutes).plusSeconds(seconds);
        return timeImpl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = convertToDuration(time);
    }

    @Override
    public String toString() {
        return "Music [id=" + id + ", name=" + name + ", author=" + author + ", genre=" + genre + ", time=" + time
                + "]";
    }
    
}
