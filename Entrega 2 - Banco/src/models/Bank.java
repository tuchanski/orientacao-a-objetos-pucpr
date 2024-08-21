package models;

import java.util.List;
import java.util.ArrayList;

public class Bank {

    protected List<BankAccount> bankAccounts;

    public Bank() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void add(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

}
