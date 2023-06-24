package org.udemy.service;

import org.udemy.domain.BankAccount;
import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountRepository;

import java.io.IOException;

public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    private ConsoleLogger consoleLogger;

    public BankAccountService(BankAccountRepository bankAccountRepository, ConsoleLogger consoleLogger) {
        this.bankAccountRepository = bankAccountRepository;
        this.consoleLogger = consoleLogger;
    }

    public void save(BankAccount bankAccount) {
        try{
            bankAccountRepository.save(bankAccount);
            this.consoleLogger.writeInfo("Bank Account with ID " + bankAccount.getId() + " saved");
        } catch (IOException exception) {
            this.consoleLogger.writeError("ERROR : could not save Bank Account with ID " + bankAccount.getId(),exception);
        }
    }
}
