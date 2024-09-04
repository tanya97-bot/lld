package org.example.Observable;

import org.example.Observer.NotifcationAlertObserver;

public interface StockObservable {


    public void notifySubscribers();

    public void addSubscribers(NotifcationAlertObserver observer);

    public void removeSubscriber(NotifcationAlertObserver observer);

    public void setStock(int units);

    int getStock();


}
