package za.co.admatech.factory;

import za.co.admatech.domain.Money;
import za.co.admatech.util.Helper;

public class MoneyFactory {
    public static Money createMoney(double amount, String currency) {
        if (amount < 0 || Helper.isNullOrEmpty(currency) || !currency.matches("[A-Z]{3}")) {
            return null;
        }
        return new Money.Builder()
                .setAmount(amount)
                .setCurrency(currency)
                .build();
    }
}

