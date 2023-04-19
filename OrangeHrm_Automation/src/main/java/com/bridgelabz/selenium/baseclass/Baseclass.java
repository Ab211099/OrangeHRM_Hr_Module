package com.bridgelabz.selenium.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Baseclass {

    public static WebDriver driver;
    static Logger log = Logger.getLogger(Baseclass.class.getName());
    public void initialization(String browserName) {

        PropertyConfigurator.configure("C:\\TFP\\OrangeHRM_Hr_Module\\OrangeHrm_Automation\\log4j.properties");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://administrato-trials77.orangehrmlive.com/auth/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            log.info("Chrome browser launched successfully!!!");


        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.manage().window().maximize();
            driver.get("https://www.linkedin.com/signup");
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public void tearDown(){ driver.quit();}
}
