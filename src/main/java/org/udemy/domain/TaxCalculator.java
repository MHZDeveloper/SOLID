package org.udemy.domain;

public class TaxCalculator {

    public double calculateTax(BankAccount bankAccount) {
        if (bankAccount instanceof CheckingBankAccount) {
            return 30 + ((bankAccount.getBalance() * 0.01) / 100);
        } else if (bankAccount instanceof SavingsBankAccount) {
            return 50 + ((bankAccount.getBalance() * 0.03) / 100);
        } else if (bankAccount instanceof MoneyMarketBankAccount) {
            return 40 + ((bankAccount.getBalance() * 0.02) / 100);
        } else {
            throw new RuntimeException("Invalid Bank Account Type");
        }
    }
}
