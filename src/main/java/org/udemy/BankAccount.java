package org.udemy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static void save(BankAccount bankAccount) {
        try {
            String record = "### Bank Account " + bankAccount.id + " Record ###" +
                    System.lineSeparator() +
                    "BALANCE : " + bankAccount.balance +
                    System.lineSeparator() +
                    "HOLDER : " + bankAccount.holder +
                    System.lineSeparator() +
                    "EMAIL : " + bankAccount.email +
                    System.lineSeparator() +
                    "TIMESTAMP : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                    System.lineSeparator();

            Path path = Paths.get("Bank_Account_" + bankAccount.id + ".txt");
            Files.write(path, record.getBytes());

            System.out.println("Bank Account with ID " + bankAccount.id + " saved");
        } catch (IOException exception) {
            System.out.println("ERROR : could not save Bank Account with ID " + bankAccount.id);
        }
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

