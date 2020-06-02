package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    @BeforeClass
    public static void Log(){
        Logger.getLoggerInstance().log("someInterestingLog");
    }

    @Test
    public void testGetLastLog(){
        //Given
        //When
        String result = Logger.getLoggerInstance().getLastLog();
        System.out.println("Last log: " + result);
        //Then
        Assert.assertEquals("someInterestingLog",result);
    }
}
