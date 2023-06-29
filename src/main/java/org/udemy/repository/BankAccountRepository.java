package org.udemy.repository;

import org.udemy.domain.BankAccount;
import org.udemy.domain.SavingsBankAccount;

import java.io.IOException;
import java.util.List;

public interface BankAccountRepository {
    List<BankAccount> findAll();
    List<SavingsBankAccount> findAllSavingsAccounts();
    void save(BankAccount bankAccount) throws IOException;
}
