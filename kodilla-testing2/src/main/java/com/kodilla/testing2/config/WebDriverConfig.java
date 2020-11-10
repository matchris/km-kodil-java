package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public final static String CHROME = "CHROME_DRIVER";
    public final static String FIREFOX = "FIREFOX_DRIVER";

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.chrome.driver", "/home/chris/Selenium-drivers/Chrome/chromedriver");
        System.setProperty("webdriver.firefox.driver", "/home/chris/Selenium-drivers/Firefox/geckodriver");

        if(driver.equals(FIREFOX)) {
            return new FirefoxDriver();
        } else if(driver.equals(CHROME)) {
            return new ChromeDriver();
        } else {
            return null;
        }
    }
}
