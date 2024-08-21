package models;

import java.util.List;

public class Bank {

    protected List<BankAccount> bankAccounts;

    public Bank() {
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void add(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

}
