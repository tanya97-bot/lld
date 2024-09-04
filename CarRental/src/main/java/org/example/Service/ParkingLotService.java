package org.example.Service;

import org.example.Model.ParkingLot;

public class ParkingLotService implements IParkingLotService{

    @Override
    public void viewOccupiedSlots(ParkingLot pl) {
        System.out.println(pl.getOccupiedSlots());
    }

    @Override
    public void viewAvailableSlots(ParkingLot pl) {
        System.out.println(pl.getAvailableSlots());
    }
}
