package org.udemy.domain.taxes;

import org.udemy.domain.BankAccount;

public interface TaxCalculator {
    double calculateTax(BankAccount bankAccount);
}
