package org.udemy.service;

import org.udemy.domain.BankAccount;
import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountFileRepository;

import java.io.IOException;
import java.util.List;

public class BankAccountService {

    private BankAccountFileRepository bankAccountRepository;

    private ConsoleLogger consoleLogger;

    public BankAccountService(BankAccountFileRepository bankAccountRepository, ConsoleLogger consoleLogger) {
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

    public List<BankAccount> findAll() {
        consoleLogger.writeInfo("Getting all Bank Accounts");
        return bankAccountRepository.findAll();
    }
}
