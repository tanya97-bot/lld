package org.example;

import org.example.model.PrinterType;
import org.example.model.State;
import org.example.service.Printer;

public class Main {
    public static void main(String[] args) {
        State sharedstate = new State(PrinterType.ODD);
        int max = 100;
        Printer odd = new Printer(2,sharedstate,PrinterType.ODD, PrinterType.EVEN,max, 1);
        Printer even = new Printer(2,sharedstate,PrinterType.EVEN, PrinterType.ODD,max, 2);

        Thread oddThread = new Thread(odd);
        Thread evenThread = new Thread(even);
        oddThread.start();
        evenThread.start();

    }
}