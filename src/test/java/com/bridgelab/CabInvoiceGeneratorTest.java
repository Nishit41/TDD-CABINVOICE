package com.bridgelab;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator generator;
    @Test
    void givenDistanceAndTime_Should_Return_Total_Fare_Of_Money() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(0.5, 8.9);
        System.out.println(totalFare);
        Assert.assertEquals(13.9,totalFare);
    }
    @Test
    void givenDistanceAndTime_Should_Return_Minimum_Fare_Of_Money(){
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(0.4, 1);
        System.out.println(totalFare);
        Assert.assertEquals(5,totalFare);
    }

    @Test
    void givenMultipleRide_Should_Return_TotalFare(){
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        Ride[] rides = { new Ride(Ride.Category.NORMAL_RIDE, 2.0,5), new Ride(Ride.Category.NORMAL_RIDE, 1.0,6)};
        double totalFare = generator.calculateFare(rides);
        //double totalFare = generator.calculateFare(rides);
        Assert.assertEquals(41,totalFare);
    }
    @Test
    void givenMultipleRide_Should_Return_Invoice() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(Ride.Category.NORMAL_RIDE, 2.0, 5), new Ride(Ride.Category.NORMAL_RIDE, 1.0, 6)};
        Invoice actualInvoice = generator.getInvoice(rides);
        Invoice expectedInvoice = new Invoice(2, 41, 20.5);
        Assert.assertEquals(actualInvoice,expectedInvoice);
    }
    @Test
    void givenUserIdShouldReturnInvoice(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,4,10);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,5,10);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        Customer customer = new Customer(1,rides);
        customer.rideList = rides;
//        customer.rideList.add(ride1);
//        customer.rideList.add(ride2);
//        customer.rideList.add(ride3);
        CabInvoiceGenerator.customerList.add(customer);
        Ride ride4 = new Ride(Ride.Category.NORMAL_RIDE,3,15);
        Ride[] rides1 = new Ride[]{ride4};
        Customer customer2 = new Customer(2,rides1);
        customer2.rideList = rides1;
//        customer2.rideList.add(ride4);
        CabInvoiceGenerator.customerList.add(customer2);
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(1);
        Invoice expectedInvoice = new Invoice(3,150,50.0);
        Assert.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    void givenUserIdShouldReturnTheInvoiceForRespectiveRides(){

        Ride ride4 = new Ride(Ride.Category.PREMIUM_RIDE,8,4);
        Ride ride5 = new Ride(Ride.Category.PREMIUM_RIDE,6,3);
        Ride ride6 = new Ride(Ride.Category.PREMIUM_RIDE,0.2,1);
        Ride[] rides2 = {ride4,ride5,ride6};
        Customer customer1 = new Customer(1,rides2);
        CabInvoiceGenerator.customerList.add(customer1);
        Invoice actualInvoice=CabInvoiceGenerator.generateInvoice(1);
        Invoice expectedInvoice = new Invoice(3,152,152/3);
        Assert.assertEquals(expectedInvoice,actualInvoice);
    }

}
