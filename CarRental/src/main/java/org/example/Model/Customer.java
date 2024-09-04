package org.example.Model;

public class Customer {
    Vehicle vehicle;
    String cxName;
    String cid;

    public Customer(Vehicle vehicle, String cxName, String cid) {
        this.vehicle = vehicle;
        this.cxName = cxName;
        this.cid = cid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getCxName() {
        return cxName;
    }

    public void setCxName(String cxName) {
        this.cxName = cxName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
