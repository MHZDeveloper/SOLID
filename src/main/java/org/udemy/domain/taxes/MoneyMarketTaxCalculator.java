package org.udemy.domain.taxes;

import org.udemy.domain.BankAccount;

public class MoneyMarketTaxCalculator implements TaxCalculator{
    public double calculateTax(BankAccount bankAccount) {
        return 40 + ((bankAccount.getBalance() * 0.02) / 100);
    }
}
