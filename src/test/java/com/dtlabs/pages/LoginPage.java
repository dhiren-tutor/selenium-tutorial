package com.dtlabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(){
        //driver = PageDriver.getDriver();
        //driver = PageDriver.getCurrentDriver();

        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "user-name")
    public WebElement userName;
    @FindBy(how = How.ID, using = "password")
    public WebElement password;
    @FindBy(how = How.ID, using = "login-button")
    public WebElement signIn;


    public void login(String username, String Password){
//        userName = driver.findElement(By.id("user-name"));
//        password = driver.findElement(By.id("password"));
//        signIn = driver.findElement(By.id("login-button"));

        userName.sendKeys(username);
        password.sendKeys(Password);
        signIn.click();
    }
}
