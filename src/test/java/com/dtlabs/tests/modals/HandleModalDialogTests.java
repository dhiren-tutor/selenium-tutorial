package com.dtlabs.tests.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleModalDialogTests {

    @Test
    public void verifyModalDialogBox() throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");

        WebElement modelBtn = driver.findElement(By.xpath("//button[@data-target='#myModal']"));
        modelBtn.click();

        WebElement modalContainer = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("(//div[@class='modal-dialog'])[1]")));
        ////div[@id='myModal']//div[@class='modal-dialog']

        WebElement modalContentBody = modalContainer.findElement(By.xpath("(//div[@class='modal-body'])[1]"));
        String actual = "This is the place where the content for the modal dialog displays";
        Assert.assertEquals(actual, modalContentBody.getText());

        WebElement modalSaveChangesBtn = modalContainer.findElement(By.xpath("(//button[@type='button'][normalize-space()='Save Changes'])[1]"));
        modalSaveChangesBtn.click();
    }
}
