package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser janKowalski = new ForumUser("Jan Kowalski");
        ForumUser annaLesinska = new ForumUser("Anna Lesinska");
        ForumUser demiKot = new ForumUser("Demi Kot");
        javaHelpForum.registerObserver(janKowalski);
        javaHelpForum.registerObserver(annaLesinska);
        javaToolsForum.registerObserver(annaLesinska);
        javaToolsForum.registerObserver(demiKot);

        //When
        javaHelpForum.addPost("Hello to everyone on Java Help Forum");
        javaToolsForum.addPost("Hello to everyone on Java Tools Forum");
        javaHelpForum.addPost("This is second testing post JHF");
        javaToolsForum.addPost("This is second testing post JTF");
        javaHelpForum.addPost("And the last post for testing: 3rd one");
        javaHelpForum.addPost("The 3rd one wasn't the last one as I initially assumed");

        //Then
        assertEquals(4, janKowalski.getUpdateCount());
        assertEquals(6, annaLesinska.getUpdateCount());
        assertEquals(2,demiKot.getUpdateCount());
    }
}
