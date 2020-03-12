package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int addResult = calculator.addAToB(5,6 );

        if (addResult==11) {
            System.out.println("Adding Ok");
        } else {
            System.out.println("Adding Error!");
        }

        int substrResult = calculator.substrBFromA(5,6 );

        if (substrResult==-1) {
            System.out.println("Substraction Ok");
        } else {
            System.out.println("Substraction Error!");
        }
    }
}

