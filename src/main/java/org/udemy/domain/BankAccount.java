package org.udemy.domain;

public abstract class BankAccount {

    private int id;
    private double balance;
    private String holder;
    private String email;
    protected String mobileNumber;

    public BankAccount(int id, double balance, String holder, String email) {
        this.id = id;
        this.balance = balance;
        this.holder = holder;
        this.email = email;
    }

    public BankAccount(int id, double balance, String holder, String email, String mobileNumber) {
        this.id = id;
        this.balance = balance;
        this.holder = holder;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void transfer(BankAccount bankAccount, double amount) {
        this.withdraw(amount);
        bankAccount.deposit(amount);
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

    public String getMobileNumber() {
        return mobileNumber;
    }
}