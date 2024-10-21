package org.example.CallbackAndEventRunner;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Event {
    ReentrantLock rlock = new ReentrantLock();
    Condition condition = rlock.newCondition();
    private boolean isRunning;
    public void ExecuteEvent() throws InterruptedException {
        rlock.lock();
        try {
            isRunning= true;
            System.out.println("Srarted running event");
            Thread.sleep(10000);
            System.out.println(" ran event");

        }finally {
            isRunning = false;
            condition.signalAll();
            rlock.unlock();
        }

    }

    public void awaitEventCompletion() throws InterruptedException {
        rlock.lock();
        try {
            while (isRunning) {
                condition.await(); // Wait until the event completes
            }
        } finally {
            rlock.unlock();
        }
    }
}
