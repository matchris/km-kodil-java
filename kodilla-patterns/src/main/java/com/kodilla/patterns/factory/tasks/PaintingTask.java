package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{

    final String taskName;
    final String color;
    final String using;

    public PaintingTask(final String taskName, final String color, final String using) {
        this.taskName = taskName;
        this.color = color;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("We are going to " + taskName + color + " using the " + using);
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return color.equals("blue") && using.equals("brush");
    }
}
