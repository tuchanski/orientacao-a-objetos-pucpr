package models;

import java.time.LocalDateTime;

public class Tweet {

    private static Long idCounter = 0L;

    private Long id;
    private User user;
    private String description;
    private LocalDateTime timestamp;

    public Tweet(User user, String description) {
        this.id = generateId();
        this.user = user;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    private synchronized Long generateId() {
        idCounter++;
        return idCounter;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tweet [user=" + user + ", description=" + description + "]";
    }

}
