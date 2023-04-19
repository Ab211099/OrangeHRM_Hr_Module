package com.bridgelabz.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class HrAdministrator {

    static Logger log = Logger.getLogger(HrAdministrator.class.getName());
    @FindBy (xpath = "//li[@id='left_menu_item_1']")
            WebElement hrAdministrator;
    @FindBy(xpath = "//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[3]/ui-view[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement addBtn;
    @FindBy (id = "selectedEmployee_value")
    WebElement empName;
    @FindBy (id = "user_name")
    WebElement userName;
    @FindBy (xpath = "//body/div[@id='modal-holder']/div[1]/div[1]/div[1]/div[2]/form[1]/oxd-decorator[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
    WebElement essRoleDropDownBtn;
    @FindBy (linkText = "//a[@id='bs-select-1-1']")
    WebElement getEssRoleDropDownValue;

    @FindBy(xpath = "//body/div[@id='modal-holder']/div[1]/div[1]/div[1]/div[2]/form[1]/oxd-decorator[2]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]")
    WebElement supervisorRoleDropDownBtn;
    @FindBy(xpath = "//a[@id='bs-select-2-2']")
    WebElement supervisorRoleDropDownValue;
    @FindBy(xpath = "//tbody/tr[2]/td[1]/label[1]")
            WebElement checkbox;

    WebDriver driver;

    public HrAdministrator(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickHrAdminMenuBtn() throws InterruptedException {
        hrAdministrator.click();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        checkbox.click();
        addBtn.click();
        empName.sendKeys("Abhishek");
        userName.sendKeys("Bhavekar");
        essRoleDropDownBtn.click();
        getEssRoleDropDownValue.click();
        supervisorRoleDropDownBtn.click();
        supervisorRoleDropDownValue.click();
    }

}
