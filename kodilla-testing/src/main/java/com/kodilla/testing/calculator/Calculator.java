package com.kodilla.testing.calculator;

public class Calculator {
    private int a;
    private int b;

    public Calculator(){
//        this.a = a;
//        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int addAToB(int a, int b){
        return a+b;
    }

    public int substrBFromA(int a, int b){
        return a-b;
    }
}
