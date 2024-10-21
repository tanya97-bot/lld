package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PCWithLock {

    ReentrantLock lock;
    Condition condition;
    Queue<Integer> buffer;
    int cap=4;

    public PCWithLock(){
        lock = new ReentrantLock();
        condition = lock.newCondition();
        buffer = new LinkedList<>();
    }

    public void produce(int i) throws InterruptedException {
        lock.lock();
        try{
            while (buffer.size() == cap){
                System.out.println("Buffer is full, so producer is waiting");
                condition.await();
            }
            buffer.add(i);
            System.out.println("buffer after production "+buffer.toString());
            condition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }


    public void consume() throws InterruptedException {
        lock.lock();
        try{
            while(buffer.isEmpty()){
                System.out.println("Buffer is empty, so consumer is waiting");
                condition.await();
            }
            buffer.poll();
            System.out.println("buffer after consumption "+buffer.toString());
            condition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
}
