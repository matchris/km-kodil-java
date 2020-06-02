package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString() {
        //Given
        //creating the TaskList for todos
        TasksList listToDo = new TasksList("To do tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(50)
                .forEach(n-> listToDo.getTasks().add(new Task("To Do Task number " + n)));
        //Creating the TaskLIst for tasks in progress
        TasksList listInProgress = new TasksList("In progress tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n-> listInProgress.getTasks().add(new Task("In progress task")));
        //Creating the TaskList for done tasks
        TasksList listDone = new TasksList("Done tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n-> listDone.getTasks().add(new Task("Done task number " + n)));

        //creating the board and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
        System.out.println(board);

        //When
        //Then
        Assert.assertEquals(3,board.getLists().size());
    }
}
