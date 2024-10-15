package com.dtlabs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class HandleCheckBoxes {

    @Test
    public void testCheckBox() throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //select only one checkbox
        driver.findElement(By.xpath("//input[@id='sunday']")).click();

        //select all checkbox
        List<WebElement> checkBoxElem = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        for(int i=0; i< checkBoxElem.size(); i++){

            checkBoxElem.get(i).click();
        }

        //Enhanced for loop
        for(WebElement checkBox : checkBoxElem){

            checkBox.click();
        }

        //select last 3 checkboxes
        for(int i=4; i< checkBoxElem.size(); i++){
            checkBoxElem.get(i).click();
        }

        //Unselect checkbox
        // first select and then check and deselect
        for(int i=0; i< 3; i++){

            checkBoxElem.get(i).click();
        }

        Thread.sleep(3000);

        for(int i=0; i< checkBoxElem.size(); i++){

            if(checkBoxElem.get(i).isSelected()){
                checkBoxElem.get(i).click();
            }
        }


    }
}
