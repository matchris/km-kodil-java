package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

public class SettingsFileEngineTestSuite {

    @BeforeClass
    public static void openSettingsFile() {
        SettingsFileEngine.getInstance().open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingFile() {
        SettingsFileEngine.getInstance().close();
    }

    @Test
    public void testGetFileName() {
        //Given
        //When
        String filename = SettingsFileEngine.getInstance().getFileName();
        System.out.println("Opened: " + filename);
        //Then
        Assert.assertEquals("myapp.settings", filename);
    }

    @Test
    public void testLoadSetting() {
        //Given
        //When
        Boolean isLoad = SettingsFileEngine.getInstance().loadSettings();
        System.out.println("Settings is loaded: " + isLoad);
        //Then
        Assert.assertTrue(isLoad);
    }

    @Test
    public void testSaveSetting() {
        //Given
        //When
        Boolean isSaved = SettingsFileEngine.getInstance().saveSetting();
        System.out.println("Setting is saved: " + isSaved);
        //Then
        Assert.assertTrue(isSaved);
    }
}
