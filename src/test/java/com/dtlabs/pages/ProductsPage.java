package com.dtlabs.pages;

import com.dtlabs.core.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(){
        //driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".title")
    public WebElement productsText;
    //public WebElement productsText= driver.findElement(By.cssSelector(".title"));


    public void waitForProduct(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(productsText));
    }
}
