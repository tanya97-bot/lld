package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NormalCounter {

    int count;

    ReentrantLock lock;
    Condition lockContion;
    ThreadLocal<Integer> retry;
    public NormalCounter(){
        lock = new ReentrantLock();
        lockContion = lock.newCondition();
        retry = new ThreadLocal<>();
        retry.set(0);
    }

    public synchronized void countIncreaser1() throws InterruptedException {
        Thread.sleep(5);
        System.out.println(Thread.currentThread().getName()+" "+count++);
    }

    public void countIncreaser2() throws InterruptedException {
            lock.lock(); // Acquire the lock
            try {
                Thread.sleep(5);
                System.out.println(Thread.currentThread().getName() + " got lock and incremented counter " + count++);
                lockContion.signalAll();
            } finally {
                lock.unlock(); // Always unlock in the finally block
            }
        }
    }


