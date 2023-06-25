package org.udemy.domain.taxes;

import org.udemy.domain.BankAccount;

public class CheckingTaxCalculator implements TaxCalculator{
    public double calculateTax(BankAccount bankAccount) {
        return 30 + ((bankAccount.getBalance() * 0.01) / 100);
    }
}
