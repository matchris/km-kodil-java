package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;

public class FacebookTestingApp {

    public static final String XPATH_CREATEUSER = "//*[@id=\"u_0_2\"]";
    public static final String XPATH_SELECT_NAME = "//*[@id=\"u_2_b\"]";
    public static final String XPATH_SELECT_SURNAME = "//div[@class=\"_1ixn\"]/div/div[2]/div/div/input";
    public static final String XPATH_SELECT_PHONE = "//div[@class=\"mbm _a4y\"]/div/div/input";
    public static final String XPATH_SELECT_PASSWORD = "//div[@class=\"mbm _br- _a4y\"]/div/div/input";
    public static final String XPATH_SELECT_DAY = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//div[@class=\"_5k_5\"]/span/span/select[3]";
    public static final String XPATH_SELECT_SEX = "//*[@id=\"u_2_3\"]";
    public static final String XPATH_SUBMIT = "//*[@id=\"u_2_s\"]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        Thread.sleep(4000);
        driver.findElement(By.xpath(XPATH_CREATEUSER)).click();
        Thread.sleep(4000);

        WebElement searchFieldName = driver.findElement(By.xpath(XPATH_SELECT_NAME));
        searchFieldName.sendKeys("Jan");

        WebElement searchFieldSurname = driver.findElement(By.xpath(XPATH_SELECT_SURNAME));
        searchFieldSurname.sendKeys("Kowalski");

        WebElement searchFieldPhone = driver.findElement(By.xpath(XPATH_SELECT_PHONE));
        searchFieldPhone.sendKeys("666 666 666");

        WebElement searchFieldPassword = driver.findElement(By.xpath(XPATH_SELECT_PASSWORD));
        searchFieldPassword.sendKeys("kodilla_password");

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectBoardDay = new Select(selectComboDay);
        selectBoardDay.selectByValue("6");

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectBoardMonth = new Select(selectComboMonth);
        selectBoardMonth.selectByIndex(5);

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectBoardYear = new Select(selectComboYear);
        selectBoardYear.selectByValue("1966");
        Thread.sleep(4000);
        driver.findElement(By.xpath(XPATH_SELECT_SEX)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(XPATH_SUBMIT)).click();
    }
}