package com.dtlabs.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    WebDriver driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        String browser = System.getProperty("browser","chrome");

        if(browser.contains("chrome")){
            driver = new ChromeDriver();
        }else if(browser.contains("firefox")){

            driver = new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com");
        //PageDriver.getInstance().setDriver(driver);
    }

    @AfterClass
    public void tearDown(){
        //PageDriver.getInstance().getDriver().quit();
        //PageDriver.getCurrentDriver().quit();
    }
}
