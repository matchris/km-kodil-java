package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {

        //GIVEN
        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Finland", new BigDecimal("23412341234")));
        europe.addCountry(new Country("France", new BigDecimal("21312321424")));
        europe.addCountry(new Country("Germany", new BigDecimal("123241554")));

        Continent africa = new Continent("Africa");
        africa.addCountry(new Country("Guinea", new BigDecimal("555555435")));
        africa.addCountry(new Country("Egypt", new BigDecimal("2313213155")));
        africa.addCountry(new Country("Nigeria", new BigDecimal("13213311")));

        Continent asia = new Continent("Asia");
        africa.addCountry(new Country("Thailand", new BigDecimal("555555435")));
        africa.addCountry(new Country("Japan", new BigDecimal("2313213155")));


        //WHEN
        World world = new World();
        world.addContinent(africa);
        world.addContinent(europe);
        world.addContinent(europe);
        BigDecimal actualPopulation = world.getPeopleQuantity();

        //THEN
        BigDecimal expectedPopulation = new BigDecimal("95446558915");
        Assert.assertEquals(expectedPopulation, actualPopulation);
    }
}