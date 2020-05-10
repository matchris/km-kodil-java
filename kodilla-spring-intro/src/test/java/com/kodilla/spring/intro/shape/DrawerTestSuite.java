package com.kodilla.spring.intro.shape;

import org.junit.Assert;
import org.junit.Test;

public class DrawerTestSuite {
    @Test
    public void testDoDrawingWithTriangle() {
        //Given
        Triangle triangle = new Triangle();
        Drawer drawer = new Drawer(triangle);
        //When
        String  result = drawer.shape.draw();
        //Then
        Assert.assertEquals("This is a Triangle", result);
    }
    @Test
    public void testDoDrawingWithCircle(){
        //Given
        Circle circle = new Circle();
        Drawer drawer = new Drawer(circle);
        //When
        String result = drawer.doDraw();
        //Then
        Assert.assertEquals("This is a Circle",result);
    }
}