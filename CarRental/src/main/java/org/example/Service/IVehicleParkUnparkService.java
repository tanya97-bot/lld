package org.example.Service;

import org.example.Model.*;

import java.time.LocalDateTime;

public interface IVehicleParkUnparkService {

    public Ticket parkVehile(Vehicle v, Customer c, ParkingLot pl) throws Exception;
    public void unparkVehicle(Ticket t, ParkingLot pl,  LocalDateTime exitTime);
}
