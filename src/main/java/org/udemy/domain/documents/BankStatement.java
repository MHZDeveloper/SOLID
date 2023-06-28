package org.udemy.domain.documents;

import org.udemy.domain.BankAccount;
import org.udemy.domain.transaction.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankStatement implements ExportableTxt {

    private BankAccount bankAccount;

    public BankStatement(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toTxt() {
        StringBuilder transactionsRecord = new StringBuilder();
        for (Transaction transaction : bankAccount.getTransactions()) {
            transactionsRecord
                    .append("  "+ transaction.getType() + " "+ transaction.getAmount())
                    .append(System.lineSeparator());
        }
        return "### Bank Account " + bankAccount.getId() + " Statement ###" +
                System.lineSeparator() +
                "HOLDER : " + bankAccount.getHolder() +
                System.lineSeparator() +
                "EMAIL : " + bankAccount.getEmail() +
                System.lineSeparator() +
                "TIMESTAMP : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                System.lineSeparator()+
                "BALANCE : " + bankAccount.getBalance() +
                System.lineSeparator()+
                "Transactions : " +
                System.lineSeparator()+
                transactionsRecord;
    }
}
