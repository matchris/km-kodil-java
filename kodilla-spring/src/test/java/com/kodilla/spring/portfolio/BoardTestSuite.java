package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void findingWhatIsWrong(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }

    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean("board");
        //When & Then
        board.getToDoList().getTasks().add("doing task1");
        System.out.println(board.getToDoList().getTasks().add("doing task1"));
        board.getInProgressList().getTasks().add("in progress task1");
        System.out.println(board.getInProgressList().getTasks().add("in progress task1"));
        board.getDoneList().getTasks().add("done task1");
        System.out.println(board.getDoneList().getTasks().add("done task1"));

        



    }
}
