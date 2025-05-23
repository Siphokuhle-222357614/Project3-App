package za.co.admatech.domain;

import java.util.Objects;

public class Money {
    private final double amount;
    private final String currency; // ISO 4217 codes (e.g., "USD", "ZAR")

    private Money(Builder builder) {
        this.amount = builder.amount;
        this.currency = builder.currency;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    // Equals, HashCode, ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency);
    }

    // Builder Pattern
    public static class Builder {
        private double amount;
        private String currency;

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Money build() {
            if (amount < 0)
                throw new IllegalArgumentException("Amount cannot be negative.");
            if (currency == null || !currency.matches("[A-Z]{3}"))
                throw new IllegalArgumentException("Invalid currency code (use ISO 4217).");
            return new Money(this);
        }
    }
}
