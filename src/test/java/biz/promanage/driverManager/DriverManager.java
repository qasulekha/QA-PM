package biz.promanage.driverManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;

    protected abstract void startDriver() throws IOException;

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() throws IOException{
        if(driver == null){
            startDriver();
        }
        return driver;
    }
}
