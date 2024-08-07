package application;

import models.Car;
import models.Transaction;
import models.TransactionManager;
import models.User;

public class Program {

    public static void main(String[] args) {

        User user1 = new User("tuchanski", "121.258.449-09");
        User user2 = new User("afonso", "113.345.236-04");

        System.out.println(user1);
        System.out.println(user2);

        TransactionManager transactionManager = new TransactionManager();

        transactionManager.saveTransaction(new Transaction(new Car("Civic", "Honda", 120000), user2));
        transactionManager.saveTransaction(new Transaction(new Car("Onix", "Chevrolet", 50000), user1));

        System.out.println(user2.getTransactions());
        System.out.println("***********");
        System.out.println(user1.getTransactions());
        System.out.println("***********");
        // System.out.println("This has been created for demo purposes (IN 10
        // MINUTES)!");

    }

}
