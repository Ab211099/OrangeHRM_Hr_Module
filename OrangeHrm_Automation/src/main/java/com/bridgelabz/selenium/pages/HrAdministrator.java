package com.bridgelabz.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrAdministrator {

    static Logger log = Logger.getLogger(HrAdministrator.class.getName());
    @FindBy (xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")
            WebElement hrAdministrator;
    @FindBy (linkText = "add")
            WebElement addBtn;
    @FindBy (id = "selectedEmployee_value")
            WebElement empName;
    @FindBy (id = "user_name")
            WebElement userName;
    @FindBy (xpath = "//body/div[@id='modal-holder']/div[1]/div[1]/div[1]/div[2]/form[1]/oxd-decorator[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
             WebElement essRoleDropDown;
    @FindBy (linkText = "Default ESS")
            WebElement getEssRoleDropDownValue;

    WebDriver driver;
    public HrAdministrator(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnAddButton(){
        addBtn.click();
        log.info("Click on button successful!!!");

    }

    public void addNewUser(){
        hrAdministrator.click();
        empName.sendKeys("112");
        userName.sendKeys("1223");
        essRoleDropDown.click();
        getEssRoleDropDownValue.click();

    }

}
