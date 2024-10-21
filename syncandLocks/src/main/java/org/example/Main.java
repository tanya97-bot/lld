package org.example;

import org.example.CallbackAndEventRunner.Event;
import org.example.CallbackAndEventRunner.RegistrationCallback;
import org.example.CallbackAndEventRunner.UserRegistration;
import org.example.CallbackAndEventRunnerWithQueue.Event1;
import org.example.DiningPhilosopher.Chopstick;
import org.example.DiningPhilosopher.Philosopher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //runRunner();
       //callbacktesting();
       //simplecountertest();
       //pcSync();
        //pcLock();

       // callBacksAndEvent();

      //  diningPhilosopherTest();
        EventRunner();
    }

    private static void EventRunner() throws InterruptedException {
        Event1 e = new Event1();
        for(int i=1;i<=2;i++) {
            final String user = "user-"+i;
            e.register(user, ()-> {System.out.println(user+"callback exec");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        e.fireEvent();
        for(int i=3;i<=10;i++) {
            final String user = "user-"+i;
            e.register(user, ()-> {System.out.println(user+"callback exec");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

    private static void diningPhilosopherTest(){

        List<Chopstick> chopstricks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();

        for(int i=0;i<=100; i++){
            chopstricks.add(new Chopstick());
        }

        for(int i=0;i<=50; i++){
            Philosopher p= new Philosopher("philosopher"+i);
            p.left = chopstricks.get((i));
            p.right = chopstricks.get((i+1)%50);
            philosophers.add(p);
        }

        ExecutorService es = Executors.newFixedThreadPool(10);

        for(int i=1;i<=50;i++){
            final int ii =i;
            es.submit(()->{
                try {
                    philosophers.get(ii).eat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        es.shutdown();

    }

    private static void callBacksAndEvent() throws InterruptedException {
        Event e = new Event();
        UserRegistration userRegistration= new UserRegistration(e);

       for(int i=1;i<=2;i++){
           userRegistration.reg_cb("user"+i, (a)->{
               System.out.println("Performing task for "+a);
               Thread.sleep(100);
           });
       }

       Thread t = new Thread(()-> {
           try {
               e.ExecuteEvent();
           } catch (InterruptedException ex) {
               throw new RuntimeException(ex);
           }
       });

       t.start();

        for(int i=3;i<=20;i++){
            userRegistration.reg_cb("user"+i, (a)->{
                System.out.println("Performing task for "+a);
                Thread.sleep(1000);
            });
        }

        userRegistration.stopRegisteration();
    }

    private static void runRunner(){
        // Using one runnable interface to call two mthods -
        Runner task = new Runner();
        task.setFlag(true);
        Thread t1 = new Thread(task);
        task.setFlag(false);
        Thread t2 = new Thread(task);
        t2.start();

    }

    private static void simplecountertest() throws InterruptedException {
        NormalCounter counter = new NormalCounter();

        ExecutorService es = Executors.newFixedThreadPool(20);

        for(int i=0;i< 100;i++){
            es.submit(()-> {
                try {
                    counter.countIncreaser2();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        es.shutdown();
        if (!es.awaitTermination(2, TimeUnit.MINUTES)) {
            System.out.println("Some tasks didn't finish within 1 minute!");
            es.shutdownNow(); // Forcibly shut down if tasks take too long
        }
    }

    private static void pcSync(){
        ProducerConsumerWithSync pc = new ProducerConsumerWithSync();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) { // Produce 100 items
                pc.produce(i);
            }
        });

        // Consumer thread
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) { // Consume 100 items
                pc.consume();
            }
        });

        producerThread.start();
        consumerThread.start();

    }

    private static void pcLock(){
        PCWithLock pc = new PCWithLock();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) { // Produce 100 items
                try {
                    pc.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Consumer thread
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) { // Consume 100 items
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }

    private static void callbacktesting() throws InterruptedException {
        CallbackEvent callbackEvent = new CallbackEvent();

        Runnable task1 = () ->{
            callbackEvent.reg_cb(()-> System.out.println("task1"));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable task2 = () ->{
            callbackEvent.reg_cb(()-> System.out.println("task1"));
        };

        Runnable combotask = () -> {
            task1.run();
            task2.run();
        };

        Thread userThreadRegisterTwice = new Thread(()-> callbackEvent.reg_cb(()->{
            System.out.println("Executing a user task");
        }), "2xthread");

        userThreadRegisterTwice.start();

        for(int i=0;i<=2;i++){
            final int uid =i;
            Thread userThread = new Thread(()-> callbackEvent.reg_cb(()->{System.out.println("Executing a user"+uid +
                    "task");}), "user-"+i);
            userThread.start();
        }

        Thread.sleep(100);

        Thread eventThread = new Thread(() -> {callbackEvent.executeEvent(); });
        eventThread.start();


        ExecutorService tpe = Executors.newFixedThreadPool(10);

        for(int i=3;i<=50;i++){
            final int uid =i;
            tpe.submit(()-> callbackEvent.reg_cb(()->{System.out.println("Executing a user"+uid +
                    "task");}), "user-"+i);
        }

        tpe.shutdown();

    }
}