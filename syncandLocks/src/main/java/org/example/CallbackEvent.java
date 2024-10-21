package org.example;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CallbackEvent {

    private final ReentrantLock lock = new ReentrantLock();

    Semaphore semaphore = new Semaphore(10);

    private final Condition eventCompleted = lock.newCondition();

    private AtomicBoolean isEventOngoing = new AtomicBoolean(false);

    private ThreadLocal<Boolean> isLocked;

    private final ConcurrentLinkedQueue<Runnable> callbacksqueue = new ConcurrentLinkedQueue<>();

    public void reg_cb(Runnable callback){

        try{
                // Execute the callback if no event is ongoing
            if(!isEventOngoing.get()) {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is processing reg_cb and executing callback");
                callback.run(); // Execute callback immediately
            }else{
                System.out.println(Thread.currentThread().getName()+" is added to queue"+" "+lock.isHeldByCurrentThread());
                callbacksqueue.add(callback);
            }
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
            semaphore.release();
        }}


    // start event (blocks user req during the event)
    public void executeEvent(){
        lock.lock();
        try{
            System.out.println("Event started");
            isEventOngoing.set(true);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Event ended");

            isEventOngoing.set(false);
            eventCompleted.signalAll();
            while (!callbacksqueue.isEmpty()){
                System.out.println("polling callback queue");

                callbacksqueue.poll().run();
            }
            lock.unlock();
        }
    }


}
