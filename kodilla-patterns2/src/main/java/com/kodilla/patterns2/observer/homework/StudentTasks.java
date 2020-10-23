package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StudentTasks implements QueueObservable {
    private final Student student;
    private final List<MentorObserver> observers;
    private final Deque<String> tasks;

    public StudentTasks(Student student) {
        this.student = student;
        tasks = new ArrayDeque<>();
        observers = new ArrayList<>();
    }

    public void addTaskToQueue(String task) {
        tasks.offerLast(task);
        notifyObservers();
    }

    public Student getStudent() {
        return student;
    }

    public List<MentorObserver> getObservers() {
        return observers;
    }

    public Deque<String> getTasks() {
        return tasks;
    }

    @Override
    public void notifyObservers() {
        for (MentorObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void registerObserver(MentorObserver mentorObserver) {
        observers.add(mentorObserver);
    }

    @Override
    public void removeObserver(MentorObserver mentorObserver) {
        observers.remove(mentorObserver);
    }
}
