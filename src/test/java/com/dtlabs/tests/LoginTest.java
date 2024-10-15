package com.dtlabs.tests;

import com.dtlabs.core.BaseTest;
import com.dtlabs.pages.LoginPage;
import com.dtlabs.pages.ProductsPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    WebDriverWait wait;

    @Test
    public void loginPage() throws InterruptedException {
        //WebDriver driver = PageDriver.getCurrentDriver();

//        driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(20)));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();

        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage();
        productsPage.waitForProduct();

        Thread.sleep(2000);
    }
}
