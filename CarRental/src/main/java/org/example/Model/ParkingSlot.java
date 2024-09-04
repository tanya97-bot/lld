package org.example.Model;

import org.example.Model.Enum.ParkingSize;

public class ParkingSlot {
    ParkingSize parkingSize;
    int slotNumber;

    public ParkingSlot(ParkingSize parkingSize, int slotNumber) {
        this.parkingSize = parkingSize;
        this.slotNumber = slotNumber;
    }

    public ParkingSize getParkingSize() {
        return parkingSize;
    }

    public void setParkingSize(ParkingSize parkingSize) {
        this.parkingSize = parkingSize;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
