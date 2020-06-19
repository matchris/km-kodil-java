package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: TaskList Dao";
    private static final String LISTNAME = "Test: That's my list name";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(DESCRIPTION, LISTNAME);

        //When
        taskListDao.save(taskList);

        //Then
        String listName = taskList.getListName();
        List<TaskList> readTaskList = taskListDao.findByListName(listName);

        Assert.assertEquals("Test: That's my list name",readTaskList.get(0).getListName());

        //CleanUp
        readTaskList.forEach(taskListDao::delete);
    }
}