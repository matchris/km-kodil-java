package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvForumStatisticsTest {

    Statistics statisticsMock;
    AdvForumStatistics advForumStatistics;
    static int counter = 0;


    @Before
    public void beforeEveryTest() {
        System.out.println("Test Case #" + (++ counter) +" begin ");
        statisticsMock = mock(Statistics.class);
        List<String> usersListForMocking = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersListForMocking.add("John Smith" + i);
        }
        when(statisticsMock.userNames()).thenReturn(usersListForMocking);
        when(statisticsMock.commentsCount()).thenReturn(200);
        when(statisticsMock.postCount()).thenReturn(40);
        advForumStatistics = new AdvForumStatistics();
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suit: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suit: end");
    }

    @Test
    public void testPostCountZero() {

        //Given
        when(statisticsMock.postCount()).thenReturn(0);

        //When
        advForumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, advForumStatistics.getPostsNumber(), 0.01);
        Assert.assertEquals(0, advForumStatistics.getAvgPostsPerUser(), 0.01);
        Assert.assertEquals(2, advForumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(0, advForumStatistics.getAvgCommentsPerPost(), 0.01);
    }

    @Test
    public void testPostCountOneThousand() {

        //Given
        when(statisticsMock.postCount()).thenReturn(1000);

        //When
        advForumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1000, advForumStatistics.getPostsNumber(), 0.01);
        Assert.assertEquals(10, advForumStatistics.getAvgPostsPerUser(), 0.01);
        Assert.assertEquals(2, advForumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(0.2, advForumStatistics.getAvgCommentsPerPost(), 0.01); //  200/1000
    }

    @Test
    public void testCommentsZero() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        advForumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(40, advForumStatistics.getPostsNumber(), 0.01);
        Assert.assertEquals(0.4, advForumStatistics.getAvgPostsPerUser(), 0.01);
        Assert.assertEquals(0, advForumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(0, advForumStatistics.getAvgCommentsPerPost(), 0.01);

    }

    @Test
    public void testLessCommentsToPosts() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        advForumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(10, advForumStatistics.getCommentsNumber(), 0.01);
        Assert.assertEquals(0.4, advForumStatistics.getAvgPostsPerUser(), 0.01);
        Assert.assertEquals(0.1, advForumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(0.25, advForumStatistics.getAvgCommentsPerPost(), 0.01);

    }

    @Test
    public void testLessPostsToComments() {
        //Given

        //When
        advForumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(200, advForumStatistics.getCommentsNumber(), 0.01);
        Assert.assertEquals(0.4, advForumStatistics.getAvgPostsPerUser(), 0.01);
        Assert.assertEquals(2, advForumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(5, advForumStatistics.getAvgCommentsPerPost(), 0.01);

    }

    @Test
    public void testUserZero() {
        //Given
        List<String> usersListForMocking = new ArrayList<>();
        when(statisticsMock.userNames()).thenReturn(usersListForMocking);

        //When
        advForumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, advForumStatistics.getUsersNumber(), 0.01);
        Assert.assertEquals(0, advForumStatistics.getAvgPostsPerUser(), 0.01);
        Assert.assertEquals(0, advForumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(5, advForumStatistics.getAvgCommentsPerPost(), 0.01);

    }

    @Test
    public void testUserOneHundred() {
        //Given

        //When
        advForumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, advForumStatistics.getUsersNumber(), 0.01);
        Assert.assertEquals(0.4, advForumStatistics.getAvgPostsPerUser(), 0.01);
        Assert.assertEquals(2, advForumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(5, advForumStatistics.getAvgCommentsPerPost(), 0.01);

    }
}


