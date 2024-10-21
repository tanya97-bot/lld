package org.example.CallbackAndEventRunnerWithQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class Event1 {

    Lock lock = new ReentrantLock();
    Queue<Runnable> queuedTasks = new LinkedList<>();
    ExecutorService threadPool = Executors.newFixedThreadPool(20);
    boolean isEventRunning  = false;
    StampedLock sl = new StampedLock();

    public void register(String user, Runnable callback){
        if(! isEventRunning) {
            threadPool.submit(() -> {
                callback.run();
            });
        }else{
            synchronized (queuedTasks){
                System.out.println(user + "'s callback added to buffer");
                queuedTasks.add(callback);
            }
        }
    }

    public void fireEvent() throws InterruptedException {
        threadPool.submit( () -> {
        lock.lock();
        try {
            isEventRunning = true;
            System.out.println("long running event start");
            Thread.sleep(5000);
            System.out.println("long running event finish");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            isEventRunning = false;
            synchronized (queuedTasks) {
                if (!queuedTasks.isEmpty()) {
                    queuedTasks.poll().run();
                }
            }
            lock.unlock();

        }
    } );
    }
}
