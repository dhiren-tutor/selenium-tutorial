package com.dtlabs.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PopUpAndAlerts {

    @Test
    public void handlePopUps() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Normal Alert with Ok button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);

        driver.switchTo().alert().accept();

        Alert alertText = driver.switchTo().alert();
        System.out.println(alertText.getText());

        //Confirmation Alert
        //ok and cancel
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(5000);

        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

        //Prompt Alert

    }
}
