package com.bridgelab;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.Scanner;

public class CabInvoiceGeneratorTest {
    @Test
    void givenDistanceAndTime_Should_Return_Total_Fare_Of_Money() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(0.5, 8.9);
        System.out.println(totalFare);
        Assert.assertEquals(55+8.9,totalFare);
    }
    @Test
    void givenDistanceAndTime_Should_Return_Minimum_Fare_Of_Money(){
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(0.5, 8.9);
        System.out.println(totalFare);
        Assert.assertEquals(5,totalFare);

    }

    @Test
    void givenMultipleRide_Should_Return_TotalFare(){
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        Ride[] rides = { new Ride(2.0,5),
                new Ride(1.0,6)};
        double totalFare = generator.calculateFare(rides);
        //double totalFare = generator.calculateFare(rides);
        Assert.assertEquals(41,totalFare);
    }

}
