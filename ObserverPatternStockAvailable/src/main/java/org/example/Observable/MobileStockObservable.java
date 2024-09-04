package org.example.Observable;

import org.example.Observer.NotifcationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class MobileStockObservable implements StockObservable {

    List<NotifcationAlertObserver> observers;

    int stock;
    public MobileStockObservable() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void notifySubscribers() {
        for(NotifcationAlertObserver o : observers){
            o.update(stock);
        }
    }

    @Override
    public void addSubscribers(NotifcationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeSubscriber(NotifcationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void setStock(int units) {
        this.stock = units;
        notifySubscribers();
    }

    @Override
    public int getStock() {
        return this.stock;
    }
}
