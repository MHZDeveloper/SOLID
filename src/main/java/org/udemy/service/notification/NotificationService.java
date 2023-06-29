package org.udemy.service.notification;

import org.udemy.domain.BankAccount;

public interface NotificationService {
    void notify(BankAccount bankAccount);
}
