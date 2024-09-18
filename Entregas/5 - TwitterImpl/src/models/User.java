package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {

    private static Long idCounter = 0L;

    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;

    private List<Tweet> tweets = new ArrayList<>();
    private List<User> following = new ArrayList<>();
    private List<User> followers = new ArrayList<>();

    public User(String username, String password, String email, String name) {
        this.id = generateId();
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    private synchronized Long generateId() {
        idCounter++;
        return idCounter;
    }

    public Follow follow(User toBeFollowed) {
        if (toBeFollowed != null && !this.equals(toBeFollowed) && !this.following.contains(toBeFollowed)) {
            Follow follow = new Follow(this, toBeFollowed);
            toBeFollowed.addFollower(this);
            this.following.add(toBeFollowed);
            return follow;
        }
        return null;
    }

    public void addFollower(User follower) {
        if (follower != null && !this.followers.contains(follower)) {
            this.followers.add(follower);
        }
    }

    public void removeFollower(User follower) {
        if (follower != null) {
            this.followers.remove(follower);
        }
    }

    public Tweet tweet(String description) {
        Tweet tweet = new Tweet(this, description);
        this.tweets.add(tweet);
        return tweet;
    }

    public void deleteTweet(Long id) {
        Iterator<Tweet> iterator = this.tweets.iterator();
        while (iterator.hasNext()) {
            Tweet tweet = iterator.next();
            if (tweet.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Tweet not found");
    }

    public Long getId() {
        return id;
    }

    public List<Tweet> getTweets() {
        return new ArrayList<>(tweets);
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

    public List<User> getFollowers() {
        return followers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", email=" + email + ", name=" + name + "]";
    }
}
