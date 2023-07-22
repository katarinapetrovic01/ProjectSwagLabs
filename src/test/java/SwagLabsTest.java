import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsTest extends BaseTest{

    LoginPage loginPage;



    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);

    }

    @Test
    public void login()
    {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }



    @AfterMethod
    public void after()
    {
        driver.quit();
    }

}
