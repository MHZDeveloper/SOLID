package org.udemy.service.payment;

import org.udemy.domain.SavingsBankAccount;
import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountFileSerializer;
import org.udemy.repository.BankAccountRepository;
import org.udemy.service.notification.EmailService;

import java.util.List;

public class PaymentService {

    private BankAccountRepository bankAccountRepository;

    private ConsoleLogger consoleLogger;

    private EmailService emailService;

    public PaymentService() {
        BankAccountFileSerializer bankAccountFileSerializer = new BankAccountFileSerializer();
        consoleLogger = new ConsoleLogger();
        emailService = new EmailService();
        bankAccountRepository = new BankAccountRepository(bankAccountFileSerializer, consoleLogger);
    }

    public void sendPayments(double amount) {
        List<SavingsBankAccount> savingsAccounts = bankAccountRepository.findAllSavingAccounts();
        consoleLogger.writeInfo("processing payment to savings bank accounts");
        for (SavingsBankAccount bankAccount : savingsAccounts) {
            bankAccount.deposit(amount);
            emailService.notify(bankAccount);
        }
    }
}