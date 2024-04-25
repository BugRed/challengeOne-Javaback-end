package model;

import java.time.LocalDateTime;

public class ConversionCoin {

    private final LocalDateTime date;
    private final double baseValue;
    private final String baseCurrency;
    private final double finalValue;
    private final String finalCurrency;

    public ConversionCoin(double baseValue, String baseCurrency, double finalValue, String finalCurrency) {
        this.date = LocalDateTime.now();
        this.baseValue = baseValue;
        this.baseCurrency = baseCurrency;
        this.finalValue = finalValue;
        this.finalCurrency = finalCurrency;
    }


    @Override
    public String toString() {
        return "[" + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear() + " " +
                date.getHour() + ":" + date.getMinute() + "] " +
                baseValue + " " + baseCurrency + " -> " + finalValue + " " + finalCurrency;
    }
}
