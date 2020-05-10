package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static jdk.nashorn.internal.objects.Global.Infinity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");
        //When
        double result = calculator.add(2,2);
        //Then
        Assert.assertEquals(4.0,result,0.0001);
    }
    @Test
    public void testSub() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.sub(2,4);
        //Then
        Assert.assertEquals(-2.0,result,0.0001);
    }
    @Test
    public void testDiv(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");
        //When
        double result = calculator.div(2,0);
        double result1 = calculator.div(14,7);
        //Then
        Assert.assertEquals(Infinity,result,0.0001);
        Assert.assertEquals(2.0,result1,0.0001);
    }
    @Test
    public void testMultiplication(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.mul(0,4);
        double result1 = calculator.mul(11,11);
        //Then
        Assert.assertEquals(0,result,0.0001);
        Assert.assertEquals(121,result1,0.0001);
    }

}
