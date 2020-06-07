package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigMacTestSuite {
    @Test
    public void testBigMacNew() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .ingredient("salad")
                .ingredient("bacon")
                .ingredient("cucumber")
                .ingredient("onion")
                .ingredient("chili peppers")
                .ingredient("cheese")
                .ingredient("prawn")
                .ingredient("mushrooms")
                .bun("roll")
                .sauce("barbecue")
                .burgers(3)
                .build();
        //When
        System.out.println(bigMac.toString());
        int howManyIngredients = bigMac.getIngredients().size();
        String whatKindOfBun = bigMac.getBun();
        boolean isBarbecueIncluded = bigMac.getSauce().contains("barbecue");
        int howManyBurgers = bigMac.getBurgers();

        Assert.assertEquals(8,howManyIngredients);
        Assert.assertEquals("roll",whatKindOfBun);
        Assert.assertEquals(true,isBarbecueIncluded);
        Assert.assertEquals(3,howManyBurgers);
    }
}
