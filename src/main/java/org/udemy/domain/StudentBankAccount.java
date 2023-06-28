package org.udemy.domain;

public class StudentBankAccount {

    private int id;
    private double balance;
    private String holder;
    private String email;
    private String mobileNumber;

    public StudentBankAccount(int id, double balance, String holder, String email, String mobileNumber) {
        this.id = id;
        this.balance = balance;
        this.holder = holder;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public void withdraw(double amount) {
        balance-=amount;
    }
    public void transferToMobile(double amount) {
        withdraw(amount);
        System.out.println("amount " + amount + " transferred to the mobile num " + mobileNumber);
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



