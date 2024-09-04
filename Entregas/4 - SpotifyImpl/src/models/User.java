package models;

public class User {

    private static Long idCounter = 0L;

    private Long id;
    private String username;
    private String password;

    public User(String username, String password){
        idCounter++;
        this.id = idCounter;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }

}
