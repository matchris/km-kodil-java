package com.kodilla.patterns.factory;

public class Circle implements Shape{
    final String name;
    final double radius;
    public static final double PI = Math.PI;

    public Circle(final String name, final double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return PI*Math.pow(radius,2.0);
    }

    @Override
    public double getCircumference() {
        return 2*PI*radius;
    }
}
