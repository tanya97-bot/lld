package org.example.Service;

import org.example.Model.Enum.ParkingSize;

import java.time.LocalDateTime;

public interface IPriceCalculator {

    public int price(LocalDateTime st, LocalDateTime et, ParkingSize ps);
}
