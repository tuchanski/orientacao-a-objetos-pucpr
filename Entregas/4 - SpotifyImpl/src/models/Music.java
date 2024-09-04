package models;

import models.enums.Author;
import models.enums.Genre;

public class Music {

    private static Long idCounter = 0L;

    private Long id;
    private String name;
    private Author author;
    private Genre genre;

    public Music(String name, String author, String genre) {
        idCounter++;
        this.id = idCounter;
        this.name = name;
        this.author = Author.valueOf(author);
        this.genre = Genre.valueOf(genre);
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

    @Override
    public String toString() {
        return "Music [id=" + id + ", name=" + name + ", author=" + author + ", genre=" + genre + "]";
    }

    
}
