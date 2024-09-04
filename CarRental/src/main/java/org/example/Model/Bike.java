package org.example.Model;

import org.example.Model.Enum.ParkingSize;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber, ParkingSize.BIKE);
    }
}
