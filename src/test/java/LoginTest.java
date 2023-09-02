import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;

    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);}
        @Test
        public void loginWithValidData()
        {
            loginPage.LoginOnPage("standard_user","secret_sauce");
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");}

        @Test
        public void loginInvalidUserName()
        {
            loginPage.LoginOnPage("standddar","secret_sauce");
            Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");}

        @Test
        public void loginOnPageWithOutPass()
        {
            loginPage.LoginOnPage("standard_user","");
            Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required");}

        @Test
        public void loginOnPageWithOutData()
        {
            loginPage.LoginOnPage("","");
            Assert.assertEquals(loginPage.getError(),"Epic sadface: Username is required");}

        @Test
        public void loginInvalidPassword()
        {
            loginPage.LoginOnPage("standard_user","secret");
            Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");}
        @AfterMethod
        public void after()
        {
            driver.quit();
        }

    }
