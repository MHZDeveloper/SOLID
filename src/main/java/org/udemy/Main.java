package org.udemy;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1,500,"John Doe", "john.doe@mail.com");
        BankAccount.save(bankAccount);
    }

}