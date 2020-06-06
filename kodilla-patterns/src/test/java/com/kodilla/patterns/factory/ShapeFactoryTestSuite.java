package com.kodilla.patterns.factory;

import org.junit.Assert;
import org.junit.Test;


public class ShapeFactoryTestSuite {
    public static final double PI = Math.PI;

    @Test
    public void testFactoryCircle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
        //Then
        Assert.assertEquals(PI*Math.pow(4.50,2.0),circle.getArea(),0.0001);
        Assert.assertEquals("The rounded circle",circle.getName());
        Assert.assertEquals(2*PI*4.5,circle.getCircumference(),0.0001);
    }
    @Test
    public void testFactoryRectangle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        Assert.assertEquals(15*2.5,rectangle.getArea(),0.0001);
        Assert.assertEquals(2*15.+2*2.5,rectangle.getCircumference(),0.0001);
    }

    @Test
    public void testFactorySquare() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        //Then
        Assert.assertEquals(49.0,square.getArea(),0.0001);
        Assert.assertEquals(28,square.getCircumference(),0.0001);
        Assert.assertEquals("The angular square", square.getName());
    }
}
