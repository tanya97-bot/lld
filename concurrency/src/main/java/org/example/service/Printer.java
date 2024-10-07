package org.example.service;

import org.example.model.PrinterType;
import org.example.model.State;

public class Printer implements Runnable {
    private final int step;

    private  final State state;
    private int currVal;
    //thread current printer
    private final PrinterType currPrinter;
    //threads next printer
    private final PrinterType nextPrinter;
    private int maxVal;


    public Printer(int step, State state, PrinterType currPrinter, PrinterType nextPrinter, int maxVal, int currVal) {
        this.step = step;
        this.state = state;
        this.currPrinter = currPrinter;
        this.nextPrinter = nextPrinter;
        this.maxVal = maxVal;
        this.currVal = currVal;
    }


    @Override
    public void run() {
        while(currVal <= maxVal){
            synchronized (state){
                while(!currPrinter.equals(state.getNextPrinterType())){
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(currPrinter.toString() +":" + currVal);
                currVal+=step;
                state.setNextPrinterType(this.nextPrinter);
                state.notifyAll();
            }
        }
    }
}
