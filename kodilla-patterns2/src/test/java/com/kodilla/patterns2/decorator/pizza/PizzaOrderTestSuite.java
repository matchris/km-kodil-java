package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.pizza.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    private PizzaOrder pizzaOrder;
    private String testInformation;

    @Before
    public void initialData() {
        pizzaOrder = new BasicPizzaOrder();
    }

    @After
    public void closingInformation() {
        System.out.print("The order cost: " + pizzaOrder.getCost());
        System.out.println(", the order description: " + pizzaOrder.getDescription());
    }

    @Test
    public void BasicPizzaOrderDecoratorTestSuite() {
        //Given
        //When
        String pizzaDescription = pizzaOrder.getDescription();
        BigDecimal getPrice = pizzaOrder.getCost();
        //Then
        assertEquals("Ciasto + sos pomidorowy + ser", pizzaDescription);
        assertEquals(new BigDecimal(15),getPrice);
    }

    @Test
    public void SpicyAndBigPizzaOrderDecoratorTestSuite() {
        //Given
        pizzaOrder = new HotSpicesPizzaDecorator(pizzaOrder);
        pizzaOrder = new BigPizzaDecorator(pizzaOrder);
        //When
        String pizzaDescription = pizzaOrder.getDescription();
        BigDecimal getPrice = pizzaOrder.getCost();
        //Then
        assertEquals("Ciasto + sos pomidorowy + ser + ostre przyprawy rozmiar XL", pizzaDescription);
        assertEquals(new BigDecimal(40),getPrice);
    }

    @Test
    public void MegaMixPizzaOrderDecoratorTestSuite() {
        //Given
        pizzaOrder = new HotSpicesPizzaDecorator(pizzaOrder);
        pizzaOrder = new SeaFoodPizzaDecorator(pizzaOrder);
        pizzaOrder = new MediumPizzaDecorator(pizzaOrder);
        //When
        String pizzaDescription = pizzaOrder.getDescription();
        BigDecimal getPrice = pizzaOrder.getCost();
        //Then
        assertEquals("Ciasto + sos pomidorowy + ser + ostre przyprawy + owoce morza rozmiar Medium", pizzaDescription);
        assertEquals(new BigDecimal(45),getPrice);
    }
}
