package Service.StockManager;


public interface StockObserver {

    public void update(String symbol, float price);

}
