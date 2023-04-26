package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.baseclass.ReadPropertiesFile;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HrAdministrator{

    static Logger log = Logger.getLogger(HrAdministrator.class.getName());
    @CacheLookup
    @FindBy (xpath = "//li[@id='left_menu_item_1']")
    WebElement hrAdministrator;
    WebDriver driver;

    public HrAdministrator(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean clickHrAdminMenuBtn() throws InterruptedException {
        hrAdministrator.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement tableName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
        Thread.sleep(4000);
        boolean flag = tableName.isDisplayed();
        return flag;
    }
}
