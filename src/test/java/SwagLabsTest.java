import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsTest extends BaseTest{

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
        checkoutStepOnePage = new CheckoutStepOnePage(driver);

    }

    @Test
    public void loginWithValidData()
    {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginInvalidUserName()
    {
        loginPage.LoginOnPage("standddar","secret_sauce");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginOnPageWithOutPass()
    {
        loginPage.LoginOnPage("standard_user","");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required");
    }

    @Test
    public void loginOnPageWithOutData()
    {
        loginPage.LoginOnPage("","");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username is required");
    }

    @Test
    public void loginInvalidPassword()
    {
        loginPage.LoginOnPage("standard_user","secret");
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }


    @Test     //2(a)

    public void addThreeProduct(){
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.sortProducts("Price (low to high)");
        Assert.assertEquals(inventoryPage.getPrice(),"$7.99");
        inventoryPage.addOnesie();
        inventoryPage.addTshirt();
        inventoryPage.addLight();
        inventoryPage.clickOnCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getCartNumber(),"3");

    }

    @Test      //2(b)

        public void addTwoProduct(){
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addTshirt();
        inventoryPage.addLight();
        inventoryPage.clickOnCart();
        cartPage.removeTshirt();
        cartPage.removeLight();
        //cartPage.clickBurger();
        //cartPage.clickAllItems();
        cartPage.clickContinueShopp();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(),"");
    }

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
        checkoutStepOnePage.inputPersonalInfo("Katarina","Petrovic","1100");
        checkoutStepOnePage.clickFinish();

        Assert.assertEquals(checkoutStepOnePage.getInfoMessage(),"Thank you for your order!");

    }


    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}

