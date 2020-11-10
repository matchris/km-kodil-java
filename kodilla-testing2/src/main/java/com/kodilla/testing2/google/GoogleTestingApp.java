package com.kodilla.testing2.google;
import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "gLFyf";
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        driver.findElement(By.id("introAgreeButton")).click();
        WebElement searchField = driver.findElement(By.name("q"));
        Thread.sleep(1000);
        searchField.sendKeys("Kodilla");
        Thread.sleep(789);
        searchField.submit();
    }
}
