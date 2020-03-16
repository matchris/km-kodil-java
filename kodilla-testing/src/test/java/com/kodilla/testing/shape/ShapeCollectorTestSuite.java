package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;
    private ShapeCollector shapeCollector;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        shapeCollector = new ShapeCollector();
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        //When
        shapeCollector.addFigure(triangle);
        //Then
        Assert.assertEquals(triangle, shapeCollector.getFigure(0));
    }
// showFigures().

    @Test
    public void testGetFigure() {
        //Given
        Circle circle = new Circle(3.0);
        shapeCollector.addFigure(circle);

        //When
        Shape expectedFigure = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(circle,expectedFigure);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Square square = new Square(4.0);
        shapeCollector.addFigure(square);

        //When
        boolean result = shapeCollector.removeFigure(square);

        //Then
        Assert.assertTrue(result);
    }
}

