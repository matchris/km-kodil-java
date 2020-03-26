package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {5,10,15,1,2,3,4,127};
        //When
        double average = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(20.875,average,0.001);
    }
}
