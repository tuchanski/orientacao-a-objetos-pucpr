package models;

public class User {

    // This is a way to auto-generate the ID - Of course it would not work in a big
    // system.
    private static Long userIdCounter = 0L;

    private Long id;
    private String username;

    public User() {
    }

    public User(String username) {
        userIdCounter++;
        this.id = userIdCounter;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }

}
