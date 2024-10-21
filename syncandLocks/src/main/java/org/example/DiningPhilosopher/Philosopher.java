package org.example.DiningPhilosopher;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher {

    public Chopstick left;
    public Chopstick right;

    private ReentrantLock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();


    String name;

    public Philosopher(String name){
        this.name = name;
    }

    public void eat() throws InterruptedException {
        lock.lock();
        try {
            while(true) {
                if (left.pickupchopstick()) {
                    if (right.pickupchopstick()) {
                        Thread.sleep(100);
                        System.out.println(name + " is eating");
                        chew();
                        right.putdownchopstic();
                        left.putdownchopstic();
                        //cond.signalAll();
                        System.out.println(name + " ate");
                        return;
                    } else {
                        System.out.println("Witing to get chopstic " + this.name);
                    }
                    left.putdownchopstic();
                } else {
                    System.out.println("Writing to get chopstick " + this.name);
                }
            }
        }finally {
            lock.unlock();
        }

    }

    public void chew() throws InterruptedException {
        System.out.println(name +" is chewing");
        Thread.sleep(1000);
    }


}
