package com.bridgelabz.com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    static Logger log = Logger.getLogger(LoginPage.class.getName());
    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement Login;

    @FindBy (xpath = "//input[@id='txtPassword']")
    WebElement Pass;

    @FindBy (xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='divLogin']/div[2]/div[1]/form[1]/div[3]/button[1]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String userName){
        Login.sendKeys(userName);
        log.info("Username entered successfully!!!");
    }
    public void setPassword(String userPass){
        Pass.sendKeys(userPass);
        log.info("User Password entered successfully!!!");

    }

    public void loginButton(){
        loginBtn.click();
        log.info("User logged in successfully!!!");
    }
}
