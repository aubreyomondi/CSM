package com.example.csm;

public class Currencies {
    private String base;
    private String quote;
    private Double  rates;
    private static String date;


    public Currencies(String base, String quote, Double rates) {
        this.base = base;
        this.quote = quote;
        this.rates = rates;
    }

    public  String getBase() {
        return base;
    }

    public String getQuote() {
        return quote;
    }

    public Double getRates() {
        return rates;
    }

    public static String getDate() {
        return date;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setRates(Double rates) {
        this.rates = rates;
    }

    public static void setDate(String date) {
        Currencies.date = date;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "base='" + base + '\'' +
                ", quote='" + quote + '\'' +
                ", rates=" + rates +
                '}';
    }
}
