package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        double average = IntStream.range(0,numbers.length)
        .map(n-> numbers[n])
                .map(n ->{
                    System.out.println(n);
                    return n;
                })
                .average().getAsDouble();
        return average;
    }
}
