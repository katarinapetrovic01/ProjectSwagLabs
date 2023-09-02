import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;



    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);}
    @Test  //Item Total
    public void itemTotal(){
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addLight();
        inventoryPage.clickOnCart();
        Assert.assertEquals(cartPage.getInfoPrice(),"$9.99");
        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Bike Light");

        cartPage.clickCheckout();
        checkoutStepOnePage.inputPersonalInfo("Katarina","Petrovic","11000");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkoutStepOnePage.getItemTotal(),"Item total: $9.99");

    }

    @Test  //Total price
    public void Total(){
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addLight();
        inventoryPage.clickOnCart();
        Assert.assertEquals(cartPage.getInfoPrice(),"$9.99");
        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Bike Light");

        cartPage.clickCheckout();
        checkoutStepOnePage.inputPersonalInfo("Katarina","Petrovic","11000");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkoutStepOnePage.getTotal(),"Total: $10.79");

    }

    @Test
    public void BuyProductsToTheEnd()
    {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addLight();
        inventoryPage.addTshirt();
        inventoryPage.clickOnCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.inputPersonalInfo("Katarina","Petrovic","11000");
        checkoutStepOnePage.clickFinish();

        Assert.assertEquals(checkoutStepOnePage.getInfoMessage(),"Thank you for your order!");}
    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
