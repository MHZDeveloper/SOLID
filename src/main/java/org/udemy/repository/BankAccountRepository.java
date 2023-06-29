package org.udemy.repository;

import org.udemy.domain.BankAccount;
import org.udemy.domain.CheckingBankAccount;
import org.udemy.domain.MoneyMarketBankAccount;
import org.udemy.domain.SavingsBankAccount;
import org.udemy.logging.ConsoleLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BankAccountRepository {

    private BankAccountFileSerializer bankAccountFileSerializer;

    private ConsoleLogger consoleLogger;

    public BankAccountRepository(BankAccountFileSerializer bankAccountFileSerializer, ConsoleLogger consoleLogger) {
        this.bankAccountFileSerializer = bankAccountFileSerializer;
        this.consoleLogger = consoleLogger;
    }

    public void save(BankAccount bankAccount) throws IOException {
        String record = this.bankAccountFileSerializer.serialize(bankAccount);

        Path path = Paths.get("Bank_Account_" + bankAccount.getId() + ".txt");
        Files.write(path, record.getBytes());
    }

    public List<BankAccount> findAll(){
        consoleLogger.writeInfo("getting all Bank Accounts");
        return Arrays.asList(
                new CheckingBankAccount(1,500,"John Doe 1", "john.doe1@mail.com"),
                new MoneyMarketBankAccount(2,700,"John Doe 2", "john.doe2@mail.com")
        );
    }

    public List<SavingsBankAccount> findAllSavingAccounts(){
        consoleLogger.writeInfo("getting all savings Bank Accounts");
        return Arrays.asList(
                new SavingsBankAccount(3,500,"John Doe 3", "john.doe3@mail.com"),
                new SavingsBankAccount(4,700,"John Doe 4", "john.doe4@mail.com")
        );
    }
}
