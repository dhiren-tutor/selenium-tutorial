package com.dtlabs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksTest {

    WebDriver driver;
    static int brokenLinkCount=0;

    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://www.geeksforgeeks.org/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyBrokenLinks(){

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links in webpage : "+links.size());

        for(WebElement link : links){

            String url = link.getAttribute("href");
            verifyLink(url);
        }
        System.out.println("Total broken links are : " + brokenLinkCount);
    }

    public static void verifyLink(String url) {

        try{
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();


            if(httpURLConnection.getResponseCode() == 200){
                //System.out.println(url + "-" + httpURLConnection.getResponseMessage());
            }else{
                //System.out.println(url + "-" + httpURLConnection.getResponseMessage() + "-" + "is a broken link");
                brokenLinkCount++;
            }

        } catch (Exception e) {
            System.out.println(url + "-" + "is a broken link");
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
