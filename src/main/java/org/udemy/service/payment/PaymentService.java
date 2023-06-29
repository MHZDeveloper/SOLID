package org.udemy.service.payment;

import org.udemy.domain.SavingsBankAccount;
import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountRepository;
import org.udemy.service.notification.NotificationService;

import java.util.List;

public class PaymentService {

    private BankAccountRepository bankAccountRepository;

    private ConsoleLogger consoleLogger;

    private NotificationService notificationService;

    public PaymentService(BankAccountRepository bankAccountRepository, NotificationService notificationService, ConsoleLogger consoleLogger) {
        this.bankAccountRepository = bankAccountRepository;
        this.notificationService = notificationService;
        this.consoleLogger = consoleLogger;
    }

    public void sendPayments(double amount) {
        List<SavingsBankAccount> savingsAccounts = bankAccountRepository.findAllSavingsAccounts();
        consoleLogger.writeInfo("processing payment to savings bank accounts");
        for (SavingsBankAccount bankAccount : savingsAccounts) {
            bankAccount.deposit(amount);
            notificationService.notify(bankAccount);
        }
    }
}