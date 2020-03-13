package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suit: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suit: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> evenArrayList = oddNumbersExterminator.exterminate(new ArrayList<>());
        System.out.println("Testing size of empty list: " + evenArrayList.size());
        //Then
        Assert.assertEquals(new ArrayList<>(), evenArrayList);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> normalList = new ArrayList<>();
        normalList.add(2);
        normalList.add(12);
        normalList.add(13);
        normalList.add(21);
        normalList.add(45);
        normalList.add(46);
        normalList.add(55);
        normalList.add(68);
        //When
        ArrayList<Integer> evenNumberList = oddNumbersExterminator.exterminate(normalList);
        System.out.println("Testing size of normalList " + normalList.size());
        //Then
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(12);
        expectedList.add(46);
        expectedList.add(68);

        Assert.assertEquals(expectedList, evenNumberList);

    }
}
