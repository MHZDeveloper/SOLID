package org.udemy;

import org.udemy.domain.BankAccount;
import org.udemy.domain.SavingsBankAccount;
import org.udemy.domain.documents.BankStatement;

public class Main {
    public static void main(String[] args) {
        // init bank account
        BankAccount bankAccount = new SavingsBankAccount(1, 0, "user", "user@mail.com");
        bankAccount.deposit(100);
        bankAccount.withdraw(50);
        bankAccount.deposit(400);
        // export bank statement
        System.out.println(new BankStatement(bankAccount).toTxt());
    }
}