package org.example.Model;

import java.time.LocalDateTime;

public class Bill {
    Ticket ticket;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    int cost;

    public Bill(Ticket ticket, LocalDateTime startDateTime, LocalDateTime endDateTime, int cost) {
        this.ticket = ticket;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.cost = cost;
    }

    @Override
    public String toString(){
       return "Bill for customer "+ ticket.c.cxName + " with customer id "+ ticket.c.cid + " with ticket id "+ ticket.tid +
               " duration - "+startDateTime+" to "+endDateTime +". Price"+ cost;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
