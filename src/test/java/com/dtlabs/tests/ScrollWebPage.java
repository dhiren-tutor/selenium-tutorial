package com.dtlabs.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollWebPage {

    @Test
    public void scroll(){

        WebDriver driver = new ChromeDriver();

        // Open the Geeks For Geeks website
        driver.get("https://www.geeksforgeeks.org/");

        // Maximize the screen
        driver.manage().window().maximize();

        // Add implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Stating the Javascript Executor driver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Return the total height of the webpage
        long initialHeight = (long) js.executeScript("return   document.body.scrollHeight");

        // Start a while loop
        while(true){

            // Do infinite scrolling
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

            // Add implicit wait of 10 seconds
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Get current height of the page
            long currentHeight = (long) js.executeScript("return document.body.scrollHeight");

            // Steop when initial height equals to current height
            if(initialHeight == currentHeight) {
                break;
            }
            initialHeight = currentHeight;
        }
    }
}
