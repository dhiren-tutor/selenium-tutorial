package com.dtlabs.tests.gestures;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleDifferentGestures {

    WebDriver driver;
    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void verifyScroll(){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)","");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
