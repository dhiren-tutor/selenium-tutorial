package com.dtlabs.tests.makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HandleRadioButtons {

    @Test
    public void selectRadioButton(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Handle Modal Dialog
        WebElement modalContainer = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='modalMain tcnFooter']")));
        //close modal dialog
        modalContainer.findElement(By.xpath("span[@class='commonModal__close']")).click();

        //click senior citizen radio button
        //driver.findElement(By.xpath("//div[normalize-space()='Senior Citizen']")).click();
        WebElement radioBtn = driver.findElement(By.xpath("//div[normalize-space()='Senior Citizen']"));
        radioBtn.getText();
        if(radioBtn.isEnabled()){
                //isDisplayed()
                //isSelected()){


        }
        driver.quit();
    }

    @AfterTest
    public void tearDown(){

    }
}
