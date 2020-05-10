package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    Display display;

    Calculator(final Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        display.displayValue(a + b);
        return a + b;
    }

    public double sub(double a, double b) {
        display.displayValue(a - b);
        return a - b;
    }

    public double mul(double a, double b) {
        display.displayValue(a * b);
        return a*b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            System.out.println("division by zero not allowed");
            display.displayValue(0);
        } else {
            display.displayValue((double) (a / b));
        }
        return a / b;
    }
}