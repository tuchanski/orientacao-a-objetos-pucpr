package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.Bank;
import models.BankAccount;
import models.User;
import models.enums.TransactionType;

public class Program {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Bank bank = new Bank();
        boolean menuLoop = true;

        while (menuLoop) {
            try {
                printMenu();
                int userChoice = input.nextInt();

                switch (userChoice) {
                    case 0:
                        menuLoop = false;
                        break;
                    case 1:
                        registerUser(bank);
                        break;
                    case 2:
                        performTransaction(bank, TransactionType.WITHDRAW);
                        break;
                    case 3:
                        performTransaction(bank, TransactionType.DEPOSIT);
                        break;
                    case 4:
                        checkBalance(bank);
                        break;
                    default:
                        System.out.println("\nInvalid option.");
                }


            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
                input.nextLine();
            }
        }

        System.out.println("\nProgram has been finished.");
        input.close();
    }

    private static void printMenu() {


        System.out.println("\n- Central Bank of Lapa PR -");
        System.out.println("[1] - Register User");
        System.out.println("[2] - Withdraw");
        System.out.println("[3] - Deposit");
        System.out.println("[4] - Check Balance");
        System.out.println("[0] - Exit the program");
        System.out.print("\nEnter here: ");
    }

    private static void registerUser(Bank bank) {
        System.out.println("\n - Creating User -");
        System.out.print("\nEnter a username: ");

        String username = input.next();

        var checkUsernameAvailability = searchAccount(username, bank);

        if (checkUsernameAvailability == null) {
            User user = new User(username);
            bank.add(new BankAccount(user));
            System.out.println("\n- User successfully created.");
        } else {
            System.out.println("\n- User already registered.");
        }

    }

    private static void performTransaction(Bank bank, TransactionType type) {
        System.out.printf("\n - %s -\n", type.getDescription());
        System.out.print("\nEnter a username: ");
        String username = input.next();
        BankAccount account = searchAccount(username, bank);

        if (account != null) {
            try {
                System.out.print("\nEnter the desired amount: ");
                double amount = input.nextDouble();
                if (type == TransactionType.WITHDRAW) {
                    account.withdraw(amount);
                } else if (type == TransactionType.DEPOSIT) {
                    account.deposit(amount);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid amount. Please enter a valid number.");
                input.nextLine();
            }
        } else {
            System.out.println("\nUser not found.");
        }
    }

    private static void checkBalance(Bank bank) {
        System.out.println("\n - Check Available Balance -");
        System.out.print("\nEnter a username: ");
        String username = input.next();
        BankAccount account = searchAccount(username, bank);

        if (account != null) {
            account.checkAvailableCash();
        } else {
            System.out.println("\nUser not found.");
        }
    }

    private static BankAccount searchAccount(String username, Bank bank) {
        return bank.getBankAccounts().stream()
                .filter(account -> account.getUser().getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

}
