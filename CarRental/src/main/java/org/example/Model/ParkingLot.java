package org.example.Model;

import org.example.Model.Enum.ParkingSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    ConcurrentHashMap<Integer, HashMap<ParkingSize, List<ParkingSlot>>> availableSlots;
    ConcurrentHashMap<Integer, HashMap<ParkingSize, List<ParkingSlot>>> occupiedSlots;
    public static int ticketNumber;

    public static HashMap<ParkingSize, Integer> PRICES;
    public ParkingLot() {
        availableSlots = new ConcurrentHashMap<>();
        occupiedSlots = new ConcurrentHashMap<>();
        setprices();
    }

    public void addFloor(int floor) {
        if (! availableSlots.containsKey(floor)) {
            List<ParkingSlot> bikeList = new ArrayList<>();
            List<ParkingSlot> carList = new ArrayList<>();

            for (int i = 0; i <= 10; i++) {
                bikeList.add(new ParkingSlot(ParkingSize.BIKE, i));
            }
            for (int i = 11; i <= 13; i++) {
                carList.add(new ParkingSlot(ParkingSize.BIG_CAR, i));
            }
            HashMap<ParkingSize, List<ParkingSlot>> vehicles = new HashMap<>();
            vehicles.put(ParkingSize.BIKE, bikeList);
            vehicles.put(ParkingSize.BIG_CAR, carList);
            availableSlots.put(floor,vehicles);
            HashMap<ParkingSize, List<ParkingSlot>> unparked = new HashMap<>();
            unparked.put(ParkingSize.BIKE, new ArrayList<>());
            unparked.put(ParkingSize.BIG_CAR, new ArrayList<>());
            occupiedSlots.put(floor, unparked);
        }
    }

    private void setprices(){
        PRICES = new HashMap<>();
        PRICES.put(ParkingSize.BIKE, 10);
        PRICES.put(ParkingSize.BIG_CAR, 30);
    }


    public ConcurrentHashMap<Integer, HashMap<ParkingSize, List<ParkingSlot>>> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(ConcurrentHashMap<Integer, HashMap<ParkingSize, List<ParkingSlot>>> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public ConcurrentHashMap<Integer, HashMap<ParkingSize, List<ParkingSlot>>> getOccupiedSlots() {
        return occupiedSlots;
    }

    public void setOccupiedSlots(ConcurrentHashMap<Integer, HashMap<ParkingSize, List<ParkingSlot>>> occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }
}
