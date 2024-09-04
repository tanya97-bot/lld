package org.example.Service;

import org.example.Model.Enum.ParkingSize;
import org.example.Model.ParkingLot;

import java.time.LocalDateTime;

public class PriceCalculator implements IPriceCalculator {
    @Override
    public int price(LocalDateTime st, LocalDateTime et, ParkingSize ps) {
        return (et.getHour() - st.getHour())* ParkingLot.PRICES.get(ps);
    }
}
