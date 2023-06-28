package org.udemy.domain;

public class StudentBankAccount extends BankAccount {

    public StudentBankAccount(int id, double balance, String holder, String email, String mobileNumber) {
        super(id, balance, holder, email, mobileNumber);
    }

    @Override
    public void transfer(BankAccount bankAccount, double amount) {
        throw new RuntimeException("Student Bank Account cannot make transfers");
    }

    public void transferToMobile(double amount) {
        this.withdraw(amount);
        System.out.println("amount " + amount + " transferred to the mobile num " + mobileNumber);
    }
}

