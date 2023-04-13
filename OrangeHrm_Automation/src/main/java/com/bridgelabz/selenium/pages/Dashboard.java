package com.bridgelabz.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    WebDriver driver;

    @FindBy (linkText = "oxd_home_menu")
    WebElement homeBtn;

    public Dashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean homeButtonValidation(){
        Boolean flag = homeBtn.isDisplayed();
        return flag;
    }
}
