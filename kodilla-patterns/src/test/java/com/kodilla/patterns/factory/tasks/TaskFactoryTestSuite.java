package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory task = new TaskFactory();
        //When
        Task shopping = task.executeTask(TaskFactory.SHOPPING);
        //Then
        assert shopping != null;
        Assert.assertEquals("weekend shopping", shopping.getTaskName());
        System.out.println("Task is executed if task name contains weekend: " + shopping.getTaskName().contains("weekend"));
        Assert.assertEquals(true, shopping.isTaskExecuted());
        Assert.assertEquals(8, ((ShoppingTask) shopping).quantity, 0.0001);
    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory task = new TaskFactory();
        PaintingTask paintingTask2 = new PaintingTask("PaintInGreen", "green", "thumb");
        //When
        Task painting = task.executeTask(TaskFactory.PAINTING);
        //Then
        assert painting != null;
        Assert.assertNotEquals("paintSDFSD", painting.getTaskName());
        System.out.println("What we use to paint " + ((PaintingTask) painting).using);
        System.out.println("Task is executed if task name contains blue and using brush: " + painting.isTaskExecuted());
        Assert.assertEquals(true, painting.isTaskExecuted());
        Assert.assertEquals("paint", painting.getTaskName());
        Assert.assertEquals("thumb",paintingTask2.using);
    }

    @Test
    public void testDRivingTask() {
        //Given
        TaskFactory task = new TaskFactory();
        //When
        Task driving = task.executeTask(TaskFactory.DRIVING);
        //Then
        Assert.assertEquals(true,driving.isTaskExecuted());
        Assert.assertEquals("to Oklahoma",((DrivingTask)driving).where);
        Assert.assertEquals("car",((DrivingTask)driving).using);
    }
}
