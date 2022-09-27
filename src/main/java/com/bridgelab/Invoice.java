package com.bridgelab;

import java.util.Objects;

public class Invoice {

    private final int totalNoOfRide;
    private final int totalFare;
    private final double avgFarePerRide;

    public Invoice(int totalNoOfRide, int totalFare, double avgFarePerRide) {
        this.totalNoOfRide  = totalNoOfRide;
        this.totalFare = totalFare;
        this.avgFarePerRide = avgFarePerRide;
    }

    public int getTotalNoOfRide() {
        return totalNoOfRide;
    }

    public int getTotalFare() {
        return totalFare;
    }


    public double getAvgFarePerRide() {
        return avgFarePerRide;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "totalNoOfRide=" + totalNoOfRide +
                ", totalFare=" + totalFare +
                ", avgFarePerRide=" + avgFarePerRide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalNoOfRide == invoice.totalNoOfRide && totalFare == invoice.totalFare && Double.compare(invoice.avgFarePerRide, avgFarePerRide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalNoOfRide, totalFare, avgFarePerRide);
    }
}
