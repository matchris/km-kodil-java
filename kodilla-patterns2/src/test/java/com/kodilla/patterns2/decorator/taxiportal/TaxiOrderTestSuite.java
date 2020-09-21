package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxiOrderTestSuite {
    private TaxiOrder theOrder;

    @Before
    public void initialData() {
        theOrder = new BasicTaxiOrder();
    }

    @After
    public void closingInformation() {
        System.out.print("theOrder Cost: " + theOrder.getCost());
        System.out.println(", theOrder Description: " + theOrder.getDescription());
    }

    @Test
    public void testBasicTaxiOrderGetCost() {
        //Given
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(5), calculatedCost);

    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given
        //When
        String courseDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course", courseDescription);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //When
        BigDecimal theCostOfTaxiNetwork = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(5 + 35), theCostOfTaxiNetwork);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //When
        String descripitionTaxiNetwork = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network", descripitionTaxiNetwork);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        //Given
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(5 + 30 + 2), theCost);
    }

    @Test
    public void testMyTaxiNetworkWithChildSeatGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        String descriptionMyTaxiNetworkWithChildSeatDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", descriptionMyTaxiNetworkWithChildSeatDescription);
    }

    @Test
    public void testUberNetworkWithChildSeatGetDescription() {
        //Given
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        String theUberWithChildSeatDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", theUberWithChildSeatDescription);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(52), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network variant VIP + child seat", description);
    }
}

