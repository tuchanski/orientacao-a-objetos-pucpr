package application;

import models.User;
import models.VerifiedUser;
import models.Tweet;
import models.Follow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;
        User anotherUser = null;
        User user1 = new User("joao_afonso", "coxadoido", "afonso@example.com", "Joao Afonso");
        VerifiedUser user2 = new VerifiedUser("arion_mendes", "flamengo123", "arion@example.com", "Arion Mendes", "Verified");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create User");
            System.out.println("2. Create Tweet");
            System.out.println("3. Follow User");
            System.out.println("4. Delete Tweet");
            System.out.println("5. View Tweets");
            System.out.println("6. View Followers");
            System.out.println("7. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    currentUser = new User(username, password, email, name);
                    System.out.println("User created: " + currentUser);
                    currentUser.addFollower(user2);
                    currentUser.addFollower(user1);
                    break;

                case 2:
                    if (currentUser != null) {
                        System.out.print("Enter tweet description: ");
                        String description = scanner.nextLine();
                        Tweet tweet = currentUser.tweet(description);
                        System.out.println("Tweet created: " + tweet);
                    } else {
                        System.out.println("No user logged in. Please create a user first.");
                    }
                    break;

                case 3:
                    if (currentUser != null) {
                        System.out.println("Choose user to follow:");
                        System.out.println("1. " + user1.getUsername());
                        System.out.println("2. " + user2.getUsername());
                        int followChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (followChoice == 1) {
                            anotherUser = user1;
                        } else if (followChoice == 2) {
                            anotherUser = user2;
                        } else {
                            System.out.println("Invalid choice.");
                            break;
                        }

                        Follow follow = currentUser.follow(anotherUser);
                        if (follow != null) {
                            System.out.println("You are now following " + anotherUser.getUsername());
                        } else {
                            System.out.println("You are already following this user or the user does not exist.");
                        }
                    } else {
                        System.out.println("No user logged in. Please create a user first.");
                    }
                    break;

                case 4:
                    if (currentUser != null) {
                        System.out.print("Enter tweet ID to delete: ");
                        Long tweetId = scanner.nextLong();
                        scanner.nextLine();
                        try {
                            currentUser.deleteTweet(tweetId);
                            System.out.println("Tweet deleted.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("No user logged in. Please create a user first.");
                    }
                    break;

                case 5:
                    if (currentUser != null) {
                        System.out.println("Your tweets:");
                        for (Tweet tweet : currentUser.getTweets()) {
                            System.out.println(tweet);
                        }
                    } else {
                        System.out.println("No user logged in. Please create a user first.");
                    }
                    break;

                case 6:
                    if (currentUser != null) {
                        System.out.println("Your followers:");
                        for (User follower : currentUser.getFollowers()) {
                            System.out.println(follower.getUsername());
                        }
                    } else {
                        System.out.println("No user logged in. Please create a user first.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
