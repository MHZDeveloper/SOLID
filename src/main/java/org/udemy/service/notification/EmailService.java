package org.udemy.service.notification;

import org.udemy.domain.BankAccount;
import org.udemy.logging.ConsoleLogger;

public class EmailService {

    private ConsoleLogger consoleLogger;

    public EmailService() {
        consoleLogger = new ConsoleLogger();
    }

    public void notify(BankAccount bankAccount) {
        consoleLogger.writeInfo("Email sent to "+bankAccount.getEmail());
    }
}
