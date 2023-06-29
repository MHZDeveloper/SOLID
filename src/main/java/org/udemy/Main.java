package org.udemy;

import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountFileRepository;
import org.udemy.repository.BankAccountFileSerializer;
import org.udemy.repository.BankAccountRepository;
import org.udemy.service.notification.EmailService;
import org.udemy.service.notification.NotificationService;
import org.udemy.service.payment.PaymentService;

public class Main {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        BankAccountFileSerializer bankAccountFileSerializer = new BankAccountFileSerializer();
        BankAccountRepository bankAccountRepository = new BankAccountFileRepository(bankAccountFileSerializer, consoleLogger);
        NotificationService notificationService = new EmailService(consoleLogger);
        PaymentService paymentService = new PaymentService(bankAccountRepository, notificationService, consoleLogger);
        paymentService.sendPayments(200);
    }
}