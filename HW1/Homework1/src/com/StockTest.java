package com;

public class StockTest {
    public static void main(String[] args) {

        Stock stock = new Stock("BTC","Bitcoin");
        stock.setCurrentPrice(-40);//testing validation
        stock.setPreviousClosingPrice(-10);//testing validation

        System.out.printf("Symbol: %s%nName: %s%n",stock.getSymbol(),stock.getName());// checking the values of name and
                                                                                     //symbol after creating object
        stock.setPreviousClosingPrice(25);
        stock.setCurrentPrice(50);

        System.out.printf("Previous closing price: %.2f%nCurrent closing price: %.2f%nChange percent: %.2f%%",
                stock.getPreviousClosingPrice(),stock.getCurrentPrice(),stock.changePercent());
    }
}
