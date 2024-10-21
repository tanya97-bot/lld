package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerWithSync {

    public static final int cap = 2;
    private final Queue<Integer> buffer = new LinkedList<>();


    public synchronized void produce(int n)  {
        while(this.buffer.size() == cap){
            System.out.println("Buffer is full, so producer is waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Produced "+n);
        buffer.offer(n);
        System.out.println("updated buffer "+buffer.toString());

        notifyAll();
    }


    public synchronized int consume()  {
        while(this.buffer.isEmpty()){
            System.out.println("No items in buffer, so consumer is waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int c = buffer.poll();
        System.out.println("Consumed "+c);
        System.out.println("updated buffer "+buffer.toString());

        notifyAll();
        return c;
    }
}
