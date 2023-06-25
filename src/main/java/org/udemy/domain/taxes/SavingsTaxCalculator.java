package org.udemy.domain.taxes;

import org.udemy.domain.BankAccount;

public class SavingsTaxCalculator implements TaxCalculator{
    public double calculateTax(BankAccount bankAccount) {
        return 50 + ((bankAccount.getBalance() * 0.03) / 100);
    }
}
