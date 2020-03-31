package com.kodilla.exception.test;

import java.io.IOException;
import java.sql.SQLOutput;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Huston we've got Error: \"" + e + "\"\n the trying by zero division!");
        } finally {
            System.out.println("\nBut it's ok, we'll never give up and keep swimming, keep swimming ...");
        }
    }
}