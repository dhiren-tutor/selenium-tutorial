package com.dtlabs.remote;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeStandaloneTest {

    @Test
    public void remoteTest() throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();

        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, chromeOptions);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
