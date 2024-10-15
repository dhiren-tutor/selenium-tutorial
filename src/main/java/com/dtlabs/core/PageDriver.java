package com.dtlabs.core;

import org.openqa.selenium.WebDriver;

public class PageDriver {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //singleton pattern
    private static PageDriver instance = null;

    private PageDriver(){

    }

    public PageDriver getInstance(){
        if(instance == null){
            instance = new PageDriver();
        }
        return instance;
    }

    public WebDriver getCurrentDriver(){
        return getInstance().getDriver();
    }
    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }
}
