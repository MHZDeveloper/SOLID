package org.udemy;

import org.udemy.domain.BankAccount;
import org.udemy.domain.SavingsBankAccount;
import org.udemy.domain.StudentBankAccount;
import org.udemy.domain.taxes.TaxCalculator;
import org.udemy.domain.taxes.TaxCalculatorFactory;
import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountFileSerializer;
import org.udemy.repository.BankAccountRepository;
import org.udemy.service.BankAccountService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // init main bank account
        BankAccount mainBankAccount = new SavingsBankAccount(0, 100000, "Bank", "bank@mail.com");

        // init necessary classes
        BankAccountFileSerializer bankAccountSerializer = new BankAccountFileSerializer();
        BankAccountRepository bankAccountRepository = new BankAccountRepository(bankAccountSerializer);

        ConsoleLogger consoleLogger = new ConsoleLogger();
        BankAccountService bankAccountService = new BankAccountService(bankAccountRepository,consoleLogger);

        // find all bank accounts
        List<BankAccount> bankAccounts = bankAccountService.findAll();

        // withdraw taxes
        for (BankAccount bankAccount : bankAccounts) {
            TaxCalculator taxCalculator = TaxCalculatorFactory.create(bankAccount);
            double amount = taxCalculator.calculateTax(bankAccount);
            bankAccount.transfer(mainBankAccount, amount);
        }

        // reload phone balance for students
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount instanceof StudentBankAccount)
                ((StudentBankAccount) bankAccount).transferToMobile(15);
        }

        // save
        for (BankAccount bankAccount : bankAccounts)
            bankAccountService.save(bankAccount);
    }

}