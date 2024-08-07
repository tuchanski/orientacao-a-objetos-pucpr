package models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static Long idIncrementor = 1L;

    private Long id;
    private String username;
    private String cpf;

    protected List<Transaction> transactions = new ArrayList<>();

    public User(String username, String cpf) {
        this.username = username;
        this.cpf = cpf;
        this.id = idIncrementor++;
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

    public String getCpf() {
        return cpf;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", cpf=" + cpf + ", id=" + getId() + "]";
    }

}
