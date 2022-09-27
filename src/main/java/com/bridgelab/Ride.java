package com.bridgelab;

public class Ride {

    private double distance;
    private double time;
    private Category category;
    public Ride(Category normalRide, double distance, double time) {
        this.distance = distance;
        this.time = time;

    }
    public enum Category{
        NORMAL_RIDE (10, 1, 5),PREMIUM_RIDE(15,2,20);

        public final double costPerKm;
        public final int costPerMin;
        public final double minFare;

        Category(double costPerKm, int costPerMin, double minFare) {
            this.costPerKm = costPerKm;
            this.costPerMin = costPerMin;
            this.minFare = minFare;
        }
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

