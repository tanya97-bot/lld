package org.example.model;

// common shared state bw the two threads, this will be the common object to be passed to both the
// threads to wait/sleep & resume work ie tells which thread turn is it to do the job
public class State {
    private PrinterType nextPrinterType;

    public State(final PrinterType next ){
        nextPrinterType = next;
    }

    public PrinterType getNextPrinterType() {
        return nextPrinterType;
    }

    public void setNextPrinterType(PrinterType nextPrinterType) {
        this.nextPrinterType = nextPrinterType;
    }
}
