package com;

public class Stock {

    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name) {
        if (symbol != null) {      //validations in constructor because we
            this.symbol = symbol;  //don't have setters for symbol and name
        } else {
            System.out.println("Invalid value. Symbol was not set!");
            this.symbol = "";
        }

        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Invalid value. Name was not set!");
            this.name = "";
        }

        setPreviousClosingPrice(0); //using setters because of the
        setCurrentPrice(0);         //validation included in them
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(double price) {
        if (price >= 0) {       //price must be non-negative
            this.previousClosingPrice = price;
        } else {
            System.out.println("Invalid value. Previous closing price was not set!");
            this.previousClosingPrice = 0; //setting default value
        }
    }

    public void setCurrentPrice(double price) {
        if (price >= 0) {     //price must be non-negative
            this.currentPrice = price;
        } else {
            System.out.println("Invalid value. Current price was not set!");
            this.currentPrice = 0; //setting default value
        }
    }

    public double changePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
    }
}

