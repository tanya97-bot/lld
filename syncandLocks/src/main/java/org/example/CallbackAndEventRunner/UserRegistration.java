package org.example.CallbackAndEventRunner;

import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class UserRegistration {

    final static LinkedHashMap<RegistrationCallback,String> queuedTasks = new LinkedHashMap<>();
    final Event e;
    Semaphore s;
    ThreadLocal<Integer> retries;

    public UserRegistration(Event e){
        this.e = e;
        s = new Semaphore(2, true);
        retries = new ThreadLocal<>();
        retries.set(0);
    }

    private final ExecutorService userRegistrationPool = Executors.newFixedThreadPool(10);


    public void reg_cb(String username, RegistrationCallback callback) throws InterruptedException {
        if(s.tryAcquire()) {
            try {
                userRegistrationPool.submit(() -> {
                    try {
                        e.awaitEventCompletion();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Executing cb for " + username);
                    try {
                        Thread.sleep(100);
                        callback.onRegistrationComplete(username);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }finally {
                s.release();
            }
        }else{
            if(retries.get() < 4) {
                Thread.sleep(1000);
                retries.set(retries.get() + 1);
                System.out.println(username+" couldn't acquire semaphore lock, so its retrying");
            }else{
                System.out.println(username+" couldn't after 4 requests, dropping reg_cb req");
            }
        }
    }

    public void stopRegisteration() throws InterruptedException {
        userRegistrationPool.shutdown();
        Thread.sleep(1000);
    }
}
