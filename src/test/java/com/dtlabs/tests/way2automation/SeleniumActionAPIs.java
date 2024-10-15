package com.dtlabs.tests.way2automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumActionAPIs {

    WebDriver driver;
    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
    }

    @Test
    public void verifySlider(){

        driver.get("https://jqueryui.com/slider/");
        driver.manage().window().maximize();
        //Switch to iframe
        WebElement frameElem = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameElem);

        WebElement slider = driver.findElement(By.id("slider"));
        int width = slider.getSize().width/2;

        WebElement sliderElem = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        new Actions(driver)
                .dragAndDropBy(sliderElem, width, 0)
                .perform();
    }

    @Test
    public void resizeable(){

        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);

        WebElement resizeableElem = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
        new Actions(driver)
                .dragAndDropBy(resizeableElem, 400, 400)
                .perform();
        //div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']
    }

    @Test
    public void dragable(){

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
    }

    @Test
    public void rightClick(){

        driver.get("https://deluxe-menu.com/popup-mode-sample.html");
        driver.manage().window().maximize();

        WebElement img = driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
        new Actions(driver)
                .contextClick(img)
                .perform();
    }

    @Test
    public void keyBoradEvents(){

        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("identifier"));
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
