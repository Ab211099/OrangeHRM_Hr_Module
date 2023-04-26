import com.bridgelabz.selenium.baseclass.Baseclass;
//import com.bridgelabz.selenium.pages.AddNewUser;
import com.bridgelabz.selenium.pages.*;
import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.annotations.*;

//@Listeners(ITestListener.class)
public class OrangeHrmTest extends Baseclass {
    LoginPage loginPage;
    Dashboard dashboard;
    HrAdministrator hrAdministrator;
    AddNewUser addNewUser;
    DeleteExistingUser deleteExistingUser;

    static Logger log = Logger.getLogger(OrangeHrmTest.class.getName());
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        hrAdministrator = new HrAdministrator(driver);
        addNewUser = new AddNewUser(driver);
        deleteExistingUser = new DeleteExistingUser(driver);

    }

    @Test(priority = 0)
    @Epic("Smoke Test")
    @Feature("Validate URL")
    @Severity(SeverityLevel.MINOR)
    public void validationURL_Success() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://administrato-trials77.orangehrmlive.com/auth/login", currentUrl);
        log.info("Validation Of URl Successful!!!");
    }
    @Test(priority = 1)
    @Epic("Smoke Test")
    @Feature("Login Test")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid login credentials")
    @Description("Test Description: Login test with valid credentials ")
    public void loginSuccess(){
        loginPage.setUsername("Admin");
        loginPage.setPassword("L@UwVxzE73");
        String loginPageTitle = loginPage.loginButton();
        Assert.assertEquals(loginPageTitle,"Employee Management");
        log.info("User logged in successfully!!!");
    }
    @Test(priority = 2)
    @Epic("Smoke Test")
    @Feature("Dashboard validation")
    @Severity(SeverityLevel.CRITICAL)
    public void DashboardValidation() {
        loginSuccess();
        Boolean flag = dashboard.homeButtonValidation();
        Assert.assertEquals(flag, true);
        log.info("Home button clicked successfully!!!");
    }

    @Test(priority = 3)
    @Epic("Regression test")
    @Feature("Menu button validation")
    @Severity(SeverityLevel.CRITICAL)
    public void clickOnHrAdminMenuBtn() throws InterruptedException {
        loginSuccess();
        boolean flag = hrAdministrator.clickHrAdminMenuBtn();
        Assert.assertEquals(flag,true);
        log.info("HrAdministrator menu button clicked successfully");
    }

    @Test(priority = 4 )
    @Epic("Regression test")
    @Feature("Add new user")
    @Severity(SeverityLevel.CRITICAL)
    public void addNewUser_Success() throws InterruptedException {
        loginSuccess();
        hrAdministrator.clickHrAdminMenuBtn();
        boolean flag = addNewUser.checkEmployeeAddedSuccessfully();
        Assert.assertEquals(flag,true);
        log.info("New user Added successfully");
    }

    @Test( priority = 5)
    @Epic("Regression test")
    @Feature("Delete existing user")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteNewUser_Success() throws InterruptedException {
        loginSuccess();
        hrAdministrator.clickHrAdminMenuBtn();
        boolean flag = deleteExistingUser.deleteExistingUser();
        Assert.assertEquals(flag,true);
        log.info("Deleted existing user successfully");
    }

    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}
