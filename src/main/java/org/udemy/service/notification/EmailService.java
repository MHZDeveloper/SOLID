package org.udemy.service.notification;

import org.udemy.domain.BankAccount;
import org.udemy.logging.ConsoleLogger;

public class EmailService implements NotificationService{

    private ConsoleLogger consoleLogger;

    public EmailService(ConsoleLogger consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    public void notify(BankAccount bankAccount) {
        consoleLogger.writeInfo("Email sent to "+bankAccount.getEmail());
    }
}
