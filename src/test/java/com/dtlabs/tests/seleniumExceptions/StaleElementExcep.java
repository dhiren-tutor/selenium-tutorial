package com.dtlabs.tests.seleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaleElementExcep {

    WebDriver driver;
    static int brokenLinkCount=0;

    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyStaleElementRef(){

        WebElement tableDataLink = driver.findElement(By.linkText("Table Data Search"));
        tableDataLink.click();
        WebElement filterByField = driver.findElement(By.id("task-table-filter"));
        filterByField.sendKeys("in progress");

        driver.navigate().back();
        tableDataLink.click();
        filterByField.sendKeys("completed");
    }

    /*  Let’s see how to fix the StaleElementReferenceException by:
        1. Re-Initializing the WebElement
        2. Using Loops and Try-Catch Blocks
        3. Using ExpectedConditions
    */

    //Method 3:
    @Test
    public void testChainExpectedConditionsToHandleStaleException() {

        WebElement pageLink = driver.findElement(By.linkText("Table Data Search"));
        pageLink.click();

        By filterByField = By.id("task-table-filter");

        chainMultipleExpectedConditions(filterByField, "in progress");


        driver.navigate().back();
        pageLink = driver.findElement(By.linkText("Table Data Search"));

        pageLink.click();
        chainMultipleExpectedConditions(filterByField, "completed");

    }

    public void chainMultipleExpectedConditions(By locator, String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(locator)));

        driver.findElement(locator).sendKeys(value);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
