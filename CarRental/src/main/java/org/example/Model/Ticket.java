package org.example.Model;

import java.time.LocalDateTime;

public class Ticket {
    ParkingSlot parkingSlot;
    LocalDateTime startTime;
    Customer c;
    int tid;
    int floor;

    public Ticket(ParkingSlot parkingSlot, LocalDateTime startTime, Customer c, int tid, int floor) {
        this.parkingSlot = parkingSlot;
        this.startTime = startTime;
        this.c = c;
        this.tid = tid;
        this.floor = floor;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
