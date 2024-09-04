package org.example;

import org.example.Observable.MobileStockObservable;
import org.example.Observable.StockObservable;
import org.example.Observer.EmailObserver;
import org.example.Observer.MobileNotifObserver;
import org.example.Observer.NotifcationAlertObserver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        StockObservable observable = new MobileStockObservable();
        NotifcationAlertObserver emailObs = new EmailObserver();
        NotifcationAlertObserver mobObs = new MobileNotifObserver();
        observable.addSubscribers(emailObs);
        observable.addSubscribers(mobObs);
        observable.setStock(5);
        observable.removeSubscriber(mobObs);
        observable.setStock(4);
    }
}