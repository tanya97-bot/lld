package Model;

import Service.Publisher.Publisher;
import Service.StockManager.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class User implements StockObserver {
    private static int idCounter = 0;

    int id;
    String name;

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void addToPublishers(Publisher p) {
        this.publishers.add(p);
    }

    List<Publisher> publishers;

    public User(String name) {
        this.name = name;
        this.id = ++idCounter;
        this.publishers = new ArrayList<>();
    }

    @Override
    public void update(String symbol, float price) {
        for(Publisher p: publishers)
        {
            p.publish("User "+name+" received update for "+symbol+" at price "+price);
        }
    }
}
