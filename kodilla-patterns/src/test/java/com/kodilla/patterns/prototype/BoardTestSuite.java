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
                .limit(10)
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

        //making a shallow clone of object board
        Board cloneBoard = null;

        try {
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(cloneBoard);

        //making a deep copy of object board
        Board deepCloneBoard = null;
        try {
            deepCloneBoard = board.deepCopy();
            deepCloneBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        board.getLists().remove(listToDo);
        //Then
        Assert.assertEquals(2,board.getLists().size());
        Assert.assertEquals(2,cloneBoard.getLists().size());
        Assert.assertEquals(3,deepCloneBoard.getLists().size());
        Assert.assertEquals(cloneBoard.getLists(),board.getLists());
        Assert.assertNotEquals(deepCloneBoard.getLists(),board.getLists());
    }
}
