package org.udemy.repository;

import org.udemy.domain.BankAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

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
}
