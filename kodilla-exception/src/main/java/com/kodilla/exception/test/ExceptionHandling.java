package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String result = " ";

        try {
            result = secondChallenge.probablyIWillThrowException(34.0, 1.5);

        } catch (Exception e) {
            System.out.println("We've got Error:" + e);
        } finally {
            System.out.println("We'we done");
        }
    }
}
