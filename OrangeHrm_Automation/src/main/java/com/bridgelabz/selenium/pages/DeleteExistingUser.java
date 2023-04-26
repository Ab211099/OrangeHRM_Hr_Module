package com.bridgelabz.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteExistingUser {
    WebDriver driver;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[1]/label[1]")
    WebElement checkBox;
    @CacheLookup
    @FindBy(xpath = "//thead/tr[1]/th[1]/a[1]")
    WebElement listOption;
    @CacheLookup
    @FindBy(xpath = "Delete Selected")
    WebElement deleteBtn;

    public DeleteExistingUser(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean deleteExistingUser(){
        checkBox.click();
        listOption.click();
        deleteBtn.click();
        boolean flag = deleteBtn.isDisplayed();
        return flag;
    }
}
