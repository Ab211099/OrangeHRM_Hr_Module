import com.bridgelabz.selenium.baseclass.Baseclass;
import com.bridgelabz.selenium.pages.Dashboard;
import com.bridgelabz.selenium.pages.HrAdministrator;
import com.bridgelabz.selenium.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners
public class OrangeHrmTest extends Baseclass {
    LoginPage loginPage;
    Dashboard dashboard;
    HrAdministrator hrAdministrator;

    static Logger log = Logger.getLogger(OrangeHrmTest.class.getName());
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        hrAdministrator = new HrAdministrator(driver);
    }

    @Test(priority = 0)
    public void validationURL_Success() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://administrato-trials77.orangehrmlive.com/auth/login", currentUrl);
        log.info("Validation Of URl Successful!!!");
    }
    @Test(priority = 1)
    public void loginSuccess(){
        loginPage.setUsername("Admin");
        loginPage.setPassword("L@UwVxzE73");
        loginPage.loginButton();
        log.info("User logged in successfully!!!");
    }
    @Test(priority = 2)
    public void DashboardValidation() {
        loginSuccess();
        Boolean flag = dashboard.homeButtonValidation();
        Assert.assertEquals(flag, true);
        log.info("Home button clicked successfully!!!");
    }

    @Test(priority = 3)
    public void addEmployee(){
        loginSuccess();
        hrAdministrator.clickOnAddButton();
        hrAdministrator.addNewUser();
    }
    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}
