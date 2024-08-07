package models;

public class TransactionManager {

    private Transaction transaction;

    public TransactionManager() {
    }

    public TransactionManager(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void saveTransaction(Transaction transaction) {
        transaction.getUser().transactions.add(transaction);
    }

}
