package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.kodilla.testing2.config.WebDriverConfig.CHROME;

public class EBayTestingApp {
    public static final String SEARCHABLE = "gh-tb";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = WebDriverConfig.getDriver(CHROME);
        driver.get("https://www.ebay.com/");
//        driver.get("https://www.ebay.com/b/Laptops-Netbooks/175672/bn_1648276");
        WebElement searchField = driver.findElement(By.className(SEARCHABLE));
        searchField.sendKeys("Laptop");
        Thread.sleep(2000);
        searchField.submit();
    }
}

