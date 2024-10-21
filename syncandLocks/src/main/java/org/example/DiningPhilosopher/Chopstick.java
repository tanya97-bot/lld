package org.example.DiningPhilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private Lock lock;
    Condition condition;

    public Chopstick(){
        lock= new ReentrantLock();
        condition = lock.newCondition();
    }

    public boolean pickupchopstick() throws InterruptedException {
        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            return true;
        } else {
            System.out.println(" couldn't pick up chopstick.");
            return false;
        }
    }

    public void putdownchopstic(){
        lock.unlock();
    }
}
