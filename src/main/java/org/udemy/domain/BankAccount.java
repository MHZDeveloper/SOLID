package org.udemy.domain;

import org.udemy.domain.transaction.Transaction;
import org.udemy.domain.transaction.TransactionType;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private int id;
    private double balance;
    private String holder;
    private String email;
    private String mobileNumber;
    private List<Transaction> transactions = new ArrayList<>();

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

    public void withdraw(double amount) {
        balance-=amount;
        this.transactions.add(new Transaction(TransactionType.WITHDRAW, amount));
    }

    public void deposit(double amount) {
        balance+=amount;
        this.transactions.add(new Transaction(TransactionType.DEPOSIT, amount));
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

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

