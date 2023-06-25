package org.udemy.domain.taxes;

import org.udemy.domain.BankAccount;
import org.udemy.domain.CheckingBankAccount;
import org.udemy.domain.MoneyMarketBankAccount;
import org.udemy.domain.SavingsBankAccount;

public class TaxCalculatorFactory {

    public static TaxCalculator create(BankAccount bankAccount) {
        if (bankAccount instanceof CheckingBankAccount)
            return new CheckingTaxCalculator();
        else if (bankAccount instanceof SavingsBankAccount)
            return new SavingsTaxCalculator();
        else if (bankAccount instanceof MoneyMarketBankAccount)
            return new MoneyMarketTaxCalculator();
        else
            throw new RuntimeException("Invalid Bank Account Type");
    }
}
