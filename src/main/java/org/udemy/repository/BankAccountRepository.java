package org.udemy.repository;

import org.udemy.domain.BankAccount;
import org.udemy.domain.CheckingBankAccount;
import org.udemy.domain.MoneyMarketBankAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class BankAccountRepository {

    private BankAccountFileSerializer bankAccountFileSerializer;

    public BankAccountRepository(BankAccountFileSerializer bankAccountFileSerializer) {
        this.bankAccountFileSerializer = bankAccountFileSerializer;
    }

    public void save(BankAccount bankAccount) throws IOException {
        String record = this.bankAccountFileSerializer.serialize(bankAccount);

        Path path = Paths.get("Bank_Account_" + bankAccount.getId() + ".txt");
        Files.write(path, record.getBytes());
    }

    public List<BankAccount> findAll(){
        return Arrays.asList(
                new CheckingBankAccount(1,500,"John Doe 1", "john.doe1@mail.com"),
                new MoneyMarketBankAccount(2,700,"John Doe 2", "john.doe2@mail.com")
        );
    }
}
