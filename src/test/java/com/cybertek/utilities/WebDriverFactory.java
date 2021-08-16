package com.cybertek.utilities;


import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {
        //TASK
        //write a static method that takes a string parameter name : browserType
        //based on the value of parameter
        //it will setup the browser and
        //the method will return chromedriver or firefoxdriver object
        //name of the method: getDriver

        WebDriver driver = null;

        //Chrome ,CHROME. ChrOme
        switch (browserType.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
        return driver;
    }}
