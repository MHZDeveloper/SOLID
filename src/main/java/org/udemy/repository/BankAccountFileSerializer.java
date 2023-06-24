package org.udemy.repository;

import org.udemy.domain.BankAccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccountFileSerializer {

    public String serialize(BankAccount bankAccount) {
        return "### Bank Account " + bankAccount.getId() + " Record ###" +
                System.lineSeparator() +
                "BALANCE : " + bankAccount.getBalance() +
                System.lineSeparator() +
                "HOLDER : " + bankAccount.getHolder() +
                System.lineSeparator() +
                "EMAIL : " + bankAccount.getEmail() +
                System.lineSeparator() +
                "TIMESTAMP : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                System.lineSeparator();
    }
}
