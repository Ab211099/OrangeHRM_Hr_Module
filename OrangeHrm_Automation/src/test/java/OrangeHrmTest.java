import com.bridgelabz.com.baseclass.Baseclass;
import com.bridgelabz.com.pages.Dashboard;
import com.bridgelabz.com.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import static com.bridgelabz.com.baseclass.Baseclass.driver;

public class OrangeHrmTest extends Baseclass {
    LoginPage loginPage;
    Dashboard dashboard;
    static Logger log = Logger.getLogger(OrangeHrmTest.class.getName());
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
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

    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}
