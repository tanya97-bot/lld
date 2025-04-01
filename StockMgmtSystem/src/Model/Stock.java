package Model;

import Service.StockManager.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    String symbol;

    public List<StockObserver> getStockObserverList() {
        return stockObserverList;
    }

    public void setStockObserverList(List<StockObserver> stockObserverList) {
        this.stockObserverList = stockObserverList;
    }

    public void addToStockObserverList(StockObserver user) {
        this.stockObserverList.add(user);
    }

    List<StockObserver> stockObserverList;

    public Stock(String symbol, float price) {
        this.symbol = symbol;
        this.price = price;
        stockObserverList = new ArrayList<>();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    float price;
}
