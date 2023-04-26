package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.baseclass.ReadPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddNewUser extends ReadPropertiesFile {
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[3]/ui-view[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement addBtn;
    @CacheLookup
    @FindBy(id = "selectedEmployee_value")
    WebElement empName;
    @CacheLookup
    @FindBy(id = "user_name")
    WebElement userName;
    @FindBy(xpath = "//body/div[@id='modal-holder']/div[1]/div[1]/div[1]/div[2]/form[1]/oxd-decorator[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
    WebElement essRoleDropDownBtn;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='modal-holder']/div[1]/div[1]/div[1]/div[2]/form[1]/oxd-decorator[2]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]")
    WebElement supervisorRoleDropDownBtn;

    @FindBy(xpath = "//body/div[@id='modal-holder']/div[1]/div[1]/div[1]/div[2]/form[1]/oxd-decorator[3]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]/i[2]")
    WebElement adminRoleDropDownBtn;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='confirmpassword']")
    WebElement confirmPassField;

    WebDriver driver;

    public AddNewUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewUser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement tableName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
        Boolean flag = tableName.isDisplayed();
        if (flag == Boolean.TRUE) {
            addBtn.click();
            empName.sendKeys("John Mathews");
            userName.sendKeys("Ab211099");
            handleEssDropDown();
            handleSupervisorRoleDropDown();
            handleAdminRoleDropDown();
            passwordField.sendKeys(properties.getProperty("passwordText"));
            confirmPassField.sendKeys(properties.getProperty("confirmPasswordText"));
        }
    }

    public void handleEssDropDown() throws InterruptedException {
        essRoleDropDownBtn.click();
        WebElement essRoleDrop = driver.findElement(By.name("essrole"));
        Select select = new Select(essRoleDrop);
        select.selectByValue("string:2");
        Thread.sleep(1000);
    }

    public void handleSupervisorRoleDropDown() throws InterruptedException {
        supervisorRoleDropDownBtn.click();
        WebElement essRoleDrop = driver.findElement(By.name("supervisorrole"));
        Select select = new Select(essRoleDrop);
        select.selectByValue("string:63");
        Thread.sleep(1000);

    }

    public void handleAdminRoleDropDown() throws InterruptedException {
        adminRoleDropDownBtn.click();
        WebElement essRoleDrop = driver.findElement(By.name("adminrole"));
        Select select = new Select(essRoleDrop);
        select.selectByValue("string:40");
        Thread.sleep(1000);
    }

    public boolean checkEmployeeAddedSuccessfully() {
        boolean flag = false;
        ArrayList<WebElement> trSize = (ArrayList<WebElement>) driver.findElements(By.xpath("//table/tbody//td[2]"));
        int totalAitemInColumn = trSize.size();
        System.out.println("Total Number of aitem in column :" + totalAitemInColumn);
        System.out.println("1St index data : " + trSize.get(1).getText());
        for (int i = 0; i < totalAitemInColumn; i++) {
            System.out.println("" + trSize.get(i).getText());
            String dataInColumn = trSize.get(i).getText();

            if (dataInColumn.equalsIgnoreCase("Drogba")) {
                flag = true;
            }
        }
        return flag;
//                System.out.println("matched success");
//            } else
//                System.out.println("Not matched");


    }
}






