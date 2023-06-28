package org.udemy.domain.transaction;

public class Transaction {
    private double amount;
    private TransactionType type;

    public Transaction(TransactionType type, double amount) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}
