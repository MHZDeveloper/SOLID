package org.udemy;

public class BankAccount {

    private int id;
    private double balance;
    private String holder;
    private String email;

    public BankAccount(int id, double balance, String holder, String email) {
        this.id = id;
        this.balance = balance;
        this.holder = holder;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }

    public String getEmail() {
        return email;
    }
}

