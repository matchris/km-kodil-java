package com.kodilla.patterns2.observer.homework;

public class Mentor implements MentorObserver {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(StudentTasks studentTasks) {
        System.out.println(studentTasks.getStudent().getName() + ": Has made new tasks "
                + studentTasks.getTasks().peekLast() + " total quantity of student tasks: "
                + studentTasks.getTasks().size());
        updateCount++;
    }
}
