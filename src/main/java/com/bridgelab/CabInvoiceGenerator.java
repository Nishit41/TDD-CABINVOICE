package com.bridgelab;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CabInvoiceGenerator {
    public static int totalNumberOfRides;
    static List<Customer> customerList = new ArrayList<>();


    public static double calculateFare(double distance, double time) {
//        if(distance<0.5){
//            return 0;
//        }
//        else if (distance>0.5){
//            return distance * 10 + 1 * time;
//        }
//        return 0.0;

        int minimumfare = 5;
        double totalFare = distance * 10 + 1 * time;
        totalFare = totalFare < minimumfare ? 5 : totalFare;
        System.out.println(totalFare);
        return totalFare;
    }

    public static double calculateFare(Ride.Category category, double distance, int time) {
        if (category.equals(Ride.Category.PREMIUM_RIDE)) {
            double totalFare = distance * category.costPerKm + time * category.costPerMin;
            if (totalFare <= category.minFare)
                return category.minFare;
            return totalFare;
        } else if (category.equals(Ride.Category.NORMAL_RIDE)) {
            double totalFare = distance * category.costPerKm + time * category.costPerMin;
            if (totalFare <= category.minFare)
                return category.minFare;
            return totalFare;
        } else
            return 0;
    }

    public static double calculateFare(Ride[] rides) {
        double netFare = 0;
        double avgFarePerRide = 0;
        for (Ride ride : rides) {
            netFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return netFare;
    }

    public static Invoice getInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalNumberOfRides = rides.length;
        double averageFare = totalFare / totalNumberOfRides;

        return new Invoice(totalNumberOfRides, (int) totalFare, averageFare);
    }

    public static Invoice generateInvoice(int id) {
        List<Customer> customerList1 = customerList.stream().filter(customer -> customer.getId() == id).collect(Collectors.toList());
        Customer customer = customerList1.get(0);
        return getInvoice(customer.rideList);
    }
}



