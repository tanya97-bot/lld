package org.example.Model;

import org.example.Model.Enum.ParkingSize;

public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber, ParkingSize.BIG_CAR );
    }
}
