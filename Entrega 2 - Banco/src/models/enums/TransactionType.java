package models.enums;

public enum TransactionType {
    WITHDRAW("Withdrawing"),
    DEPOSIT("Depositing");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
