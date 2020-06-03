package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.medium.FacebookPublisher;
import com.kodilla.patterns.strategy.social.medium.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.medium.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User jan = new Millenials("Jan Miśkiewicz");
        User anna = new YGeneration("Anna Trzebiatowska");
        User ala = new ZGeneration("Ala Kotkiewicz");

        //When
        String janIsSharing = new FacebookPublisher().share();
        System.out.println("Jan is " + janIsSharing);
        String annaIsSharing = new SnapchatPublisher().share();
        System.out.println("Anna is " + annaIsSharing);
        String alaIsSharing = new TwitterPublisher().share();
        System.out.println("Ala is " + alaIsSharing);

        //Then
        Assert.assertEquals("sharing on Facebook",janIsSharing);
        Assert.assertEquals("sharing on Snapchat",annaIsSharing);
        Assert.assertEquals("sharing on Twitter",alaIsSharing);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User jan = new Millenials("Jan Miśkiewicz");
        //When
        String janIsSharing = new FacebookPublisher().share();
        System.out.println("Jan is " + janIsSharing);
        janIsSharing = new SnapchatPublisher().share();
        System.out.println("Jan is " + janIsSharing);
        //Then
        Assert.assertEquals("sharing on Snapchat",janIsSharing);
    }
}
