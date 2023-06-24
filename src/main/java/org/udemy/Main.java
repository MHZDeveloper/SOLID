package org.udemy;

import org.udemy.domain.BankAccount;
import org.udemy.domain.CheckingBankAccount;
import org.udemy.domain.TaxCalculator;
import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountFileSerializer;
import org.udemy.repository.BankAccountRepository;
import org.udemy.service.BankAccountService;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new CheckingBankAccount(1,500,"John Doe", "john.doe@mail.com");
        // init necessary classes
        BankAccountFileSerializer bankAccountSerializer = new BankAccountFileSerializer();
        BankAccountRepository bankAccountRepository = new BankAccountRepository(bankAccountSerializer);

        ConsoleLogger consoleLogger = new ConsoleLogger();
        BankAccountService bankAccountService = new BankAccountService(bankAccountRepository,consoleLogger);

        // save
        bankAccountService.save(bankAccount);

        // calculate annual tax
        System.out.println(new TaxCalculator().calculateTax(bankAccount));
    }

}