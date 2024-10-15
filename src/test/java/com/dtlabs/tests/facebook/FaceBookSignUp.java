package com.dtlabs.tests.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FaceBookSignUp {

    WebDriver driver;

    @BeforeClass
    public void invokeBrowser(){

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://www.facebook.com");
    }
    @Test
    public void verifySignUp() throws InterruptedException {

        WebElement fbElem = driver.findElement(By.xpath("//img[@alt='Facebook']"));

        if(fbElem.isDisplayed()){
            System.out.println("Sign up page opened ");
        }else
            System.out.println("Wait for the page to be loaded");

        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Dhiren");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Thakur");

        WebElement dayElem = driver.findElement(By.id("day"));
        WebElement monthElem = driver.findElement(By.id("month"));
        WebElement yearElem = driver.findElement(By.id("year"));

        Select dayDropDown = new Select(dayElem);
        Select monthDropDown = new Select(monthElem);
        Select yearDropDown = new Select(yearElem);

        dayDropDown.selectByValue("10");
        monthDropDown.selectByValue("10");
        yearDropDown.selectByValue("1987");
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
