package com.dtlabs.tests.makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleLoginDialogBox {

    @Test
    public void verifyLoginDialogBox() throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");

        WebElement modalContainer = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='modalMain tcnFooter']")));
        ////div[@id='myModal']//div[@class='modal-dialog']

        WebElement mobileNumberTxtBox = modalContainer.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']"));
        mobileNumberTxtBox.sendKeys("7000713607");

//        WebElement modalContentBody = modalContainer.findElement(By.xpath("(//div[@class='modal-body'])[1]"));
//        String actual = "This is the place where the content for the modal dialog displays";
//        Assert.assertEquals(actual, modalContentBody.getText());
//
//        WebElement modalSaveChangesBtn = modalContainer.findElement(By.xpath("(//button[@type='button'][normalize-space()='Save Changes'])[1]"));
//        modalSaveChangesBtn.click();

        driver.quit();
    }
}
