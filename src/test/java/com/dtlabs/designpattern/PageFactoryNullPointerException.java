package com.dtlabs.designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactoryNullPointerException {
        WebDriver driver;

        @FindBy(id = "username")
        WebElement username;

        @FindBy(id = "password")
        WebElement password;

        @FindBy(id = "login")
        WebElement loginButton;

        public PageFactoryNullPointerException(WebDriver driver) {
            this.driver = driver;
            // PageFactory.initElements(driver, this); // This line is missing
            //If you haven’t initialized the Page Factory in your Page Object Model (POM), you will likely encounter a NullPointerException
            //This happens because the web elements annotated with @FindBy are not initialized, and when you try to interact with them, the reference is null
        }

        public void login(String user, String pass) {
            username.sendKeys(user); // This will throw NullPointerException
            password.sendKeys(pass);
            loginButton.click();
        }
    }
