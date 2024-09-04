package org.example.Model;

import org.example.Model.Enum.ParkingSize;

public class Vehicle {
    String vehicleNumber;
    ParkingSize parkingSize;

    public Vehicle(String vehicleNumber, ParkingSize parkingSize){
        this.vehicleNumber = vehicleNumber;
        this.parkingSize = parkingSize;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public ParkingSize getParkingSize() {
        return parkingSize;
    }

    public void setParkingSize(ParkingSize parkingSize) {
        this.parkingSize = parkingSize;
    }
}
