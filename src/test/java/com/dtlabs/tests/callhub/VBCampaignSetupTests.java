package com.dtlabs.tests.callhub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VBCampaignSetupTests {

    WebDriver driver;
    static int brokenLinkCount=0;

    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://app.callhub.io/login/");
        driver.manage().window().maximize();
    }

    @Test
    public void signInCallhubAccount() throws InterruptedException {

       WebElement username = driver.findElement(By.id("id_user"));
       username.sendKeys("dhirent.2020@gmail.com");
       //click next
       driver.findElement(By.id("change-btn-text")).click();

       WebElement password = driver.findElement(By.id("id_password"));
       password.sendKeys("Callhub@123");
       //click signin
        driver.findElement(By.id("change-btn-text")).click();
        Thread.sleep(5000);
    }
    @Test
    public void createVBCampaign(){

        WebElement createCam = driver.findElement(By.xpath("//div[@class='new-creation-title']"));

        if(createCam.isDisplayed()){
            driver.findElement(By.xpath("//a[normalize-space()='Create Campaign']")).click();
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
