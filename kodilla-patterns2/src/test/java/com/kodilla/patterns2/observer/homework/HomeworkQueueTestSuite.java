package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkQueueTestSuite {
    @Test
    public void notifyAboutTasks() {
        //given
        StudentTasks janekKowalskiTasks = new StudentTasks(new Student("Janek Kowalski"));
        StudentTasks alaNiwinskaTasks = new StudentTasks(new Student("Ala Niwinska"));
        StudentTasks zoanAbiTasks = new StudentTasks(new Student("Zoan Abi"));
        Mentor alanTomczynski = new Mentor("Alan Tomczyński");
        Mentor annaLetko = new Mentor("Anna Letko");

        janekKowalskiTasks.registerObserver(alanTomczynski);
        alaNiwinskaTasks.registerObserver(annaLetko);
        zoanAbiTasks.registerObserver(annaLetko);
        //When
        janekKowalskiTasks.addTaskToQueue("Task id 1");
        janekKowalskiTasks.addTaskToQueue("Task id 2");
        alaNiwinskaTasks.addTaskToQueue("Task id 1");
        alaNiwinskaTasks.addTaskToQueue("Task id 2");
        alaNiwinskaTasks.addTaskToQueue("Task id 5");
        janekKowalskiTasks.addTaskToQueue("Task id 3");
        zoanAbiTasks.addTaskToQueue("Task id 10");
        zoanAbiTasks.addTaskToQueue("Task id 11");
        zoanAbiTasks.addTaskToQueue("Task id 15");
        zoanAbiTasks.addTaskToQueue("Task id 16");

        //Then
        assertEquals(7,annaLetko.getUpdateCount());
        assertEquals(3,alanTomczynski.getUpdateCount());
        assertEquals(3,janekKowalskiTasks.getTasks().size());
        assertEquals(3,alaNiwinskaTasks.getTasks().size());
        assertEquals(4,zoanAbiTasks.getTasks().size());

    }
}
