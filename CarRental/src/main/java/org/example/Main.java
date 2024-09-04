package org.example;

import org.example.Model.*;
import org.example.Service.IPriceCalculator;
import org.example.Service.IVehicleParkUnparkService;
import org.example.Service.PriceCalculator;
import org.example.Service.VehicleParkUnparkService;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Customer c1 = new Customer(new Car("12345"), "Tanya", "1");
        Customer c2 = new Customer(new Car("12345"), "Tanya1", "2");
        Customer c3 = new Customer(new Car("12345"), "Tanya3", "3");
        Customer c4 = new Customer(new Car("12345"), "Tanya4", "4");


        ParkingLot pl = new ParkingLot();
        pl.addFloor(1);

        IPriceCalculator priceCalculator = new PriceCalculator();
        IVehicleParkUnparkService parkUnparkService = new VehicleParkUnparkService(priceCalculator);
Ticket t1=null, t2 = null;
        try {
             t1 = parkUnparkService.parkVehile(c1.getVehicle(), c1, pl);
             t2 = parkUnparkService.parkVehile(c2.getVehicle(), c2, pl);
            Ticket t3 = parkUnparkService.parkVehile(c2.getVehicle(), c3, pl);
            Ticket t4 = parkUnparkService.parkVehile(c2.getVehicle(), c3, pl);


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            parkUnparkService.unparkVehicle(t1, pl, LocalDateTime.now().plusHours(2) );
            Ticket t3 = parkUnparkService.parkVehile(c2.getVehicle(), c3, pl);
            parkUnparkService.unparkVehicle(t2, pl, LocalDateTime.now().plusHours(4) );
            parkUnparkService.unparkVehicle(t3, pl, LocalDateTime.now().plusHours(6) );

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}