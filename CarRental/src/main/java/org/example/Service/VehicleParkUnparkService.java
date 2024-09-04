package org.example.Service;

import org.example.Model.*;

import java.time.LocalDateTime;

public class VehicleParkUnparkService implements IVehicleParkUnparkService{

    IPriceCalculator priceCalculator;

    public VehicleParkUnparkService(IPriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }


    @Override
    public Ticket parkVehile(Vehicle v, Customer c, ParkingLot pl) throws Exception {
        ParkingSlot parkedSlot = null;
        int flo =0;
        for(int floor : pl.getAvailableSlots().keySet()){
            if(pl.getAvailableSlots().get(floor).get(v.getParkingSize()).size()>0 ){
                parkedSlot = pl.getAvailableSlots().get(floor).get(v.getParkingSize()).removeFirst();
                pl.getOccupiedSlots().get(floor).get(v.getParkingSize()).add(parkedSlot);
                flo = floor;
                break;
            }
        }
        if(parkedSlot == null){
            throw new Exception("Parking slot is full");
        }
        Ticket t = new Ticket(parkedSlot, LocalDateTime.now(),c, ParkingLot.ticketNumber++, flo);
        return  t;
    }

    @Override
    public void unparkVehicle(Ticket t, ParkingLot pl, LocalDateTime exitTime) {
        int cost = priceCalculator.price(t.getStartTime(), exitTime, t.getParkingSlot().getParkingSize());
        ParkingSlot parkedSlot = t.getParkingSlot();
        pl.getOccupiedSlots().get(t.getFloor()).get(t.getParkingSlot().getParkingSize()).add(parkedSlot);
        pl.getAvailableSlots().get(t.getFloor()).remove(parkedSlot);
        System.out.println((new Bill(t, t.getStartTime(), exitTime, cost)).toString());
    }
}
