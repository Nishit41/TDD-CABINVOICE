package com.bridgelab;

public class Customer {
    private int id;
    Ride[] rideList;


    public Customer(int id, Ride[] rideList) {
        this.setId(id);
        this.rideList = rideList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
