package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        Shape getShape = null;
        if (shapes.size() >= 0 && shapes.size() > n) {
            getShape = shapes.get(n);
        }
        return getShape;
    }

    public void showFigures() {
        for(Shape shape : shapes)
            System.out.println(shape + ", ");
    }
}

