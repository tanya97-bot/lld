package Service.StockManager;

import Model.Stock;

import java.util.HashMap;
import java.util.Map;

public class StockPriceManager {
    Map<String, Stock> stockMap;

    public StockPriceManager() {
        this.stockMap = new HashMap<>();
    }

    public void addUserToStock(String symbol, StockObserver user) {
        stockMap.get(symbol).addToStockObserverList(user);
        updatePrice(symbol, stockMap.get(symbol).getPrice());
    }

    public void updatePrice(String symbol, float price)
    {
        Stock stock = stockMap.get(symbol);
        stock.setPrice(price);
        for(StockObserver user: stock.getStockObserverList())
        {
            user.update(symbol, price);
        }
    }

    public void addStock(String symbol, float price)
    {
        stockMap.put(symbol, new Stock(symbol, price));
    }

    public void removeStock(String symbol)
    {
        stockMap.remove(symbol);
    }
}
