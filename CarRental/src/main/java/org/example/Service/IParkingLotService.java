package org.example.Service;

import org.example.Model.ParkingLot;

public interface IParkingLotService {

    public void viewOccupiedSlots(ParkingLot pl);

    public void viewAvailableSlots(ParkingLot pl);
}
