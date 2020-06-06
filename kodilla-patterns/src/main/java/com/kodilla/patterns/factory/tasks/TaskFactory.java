package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task executeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING:
                return new DrivingTask("drive", "to Oklahoma", "car");
            case PAINTING:
                return new PaintingTask("paint", "blue", "brush");
            case SHOPPING:
                return new ShoppingTask("weekend shopping", "boxes of milk", 8.0);
            default:
                return null;
        }
    }
}
