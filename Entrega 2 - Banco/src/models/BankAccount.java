package models;

public class BankAccount {

    private static Long bankIdCounter = 0L;

    private Long id;
    private User user;
    private Double availableCash;

    public BankAccount(User user) {
        bankIdCounter++;
        this.id = bankIdCounter;
        this.user = user;
        this.availableCash = 0.0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAvailableCash() {
        return availableCash;
    }

    public void deposit(Double value) {

        try {
            this.availableCash += value;
            System.out.println("The amount of R$" + value + " has been deposited to [" + this.id + "] account.");
        }

        catch (Exception e) {
            System.out.println("It was not possible to deposit to [" + this.id + "] account.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void withdraw(Double value) {

        if (this.availableCash >= value) {
            this.availableCash -= value;
            System.out.println("The amount of R$" + value + " has been withdrawn.");
        } else {
            System.out.println("Not enough cash available.");
        }

    }

    public void checkAvailableCash() {
        double availableCash = getAvailableCash();
        System.out.println(String.format("The account [%d] has R$%.2f", this.id, availableCash));
    }

    @Override
    public String toString() {
        return "BankAccount [id=" + id + ", user=" + user + ", availableCash=" + availableCash + "]";
    }

}
