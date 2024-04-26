package com.ad.basedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
    protected static String url = "https://v2.groundfloor.co/login";
	WebDriver driver;    //initializing the webdriver variable

    @BeforeSuite
    public void StartBrowser(){
        String browserName = System.getProperty("browser", "firefox"); //check wheather system has browser for opening

        if(browserName.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup(); //firefox initialize
            driver = new FirefoxDriver();  // firefox driver object assigning to driver variable
            driver.manage().window().maximize();
        }
        else if(browserName.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        else
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        PageDriver.getInstance().setDriver(driver);

    }
    @AfterSuite
    public void close()
    {
        driver.close();
    }

	
	
	
}
