package com.dtlabs.tests.way2automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleMouseOverTest {

    WebDriver driver;
    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyMouseOver(){

        //search way2Automation on Google
        driver.findElement(By.name("q")).sendKeys("way2Automation");

        //click on Google search button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']"))).click();

        //click on the first search result
        driver.findElement(By.xpath("(//span[@class='VuuXrf'][normalize-space()='Way2Automation'])[1]")).click();

        //MouseOver to Resources Menu and click Practice site 1
        WebElement hoverable = driver.findElement(By.xpath("//li[@id='menu-item-27617']//span[@class='menu-text'][normalize-space()='Resources']"));
        new Actions(driver)
                .moveToElement(hoverable)
                        .perform();
        driver.findElement(By.linkText("Practice Site 1")).click();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
