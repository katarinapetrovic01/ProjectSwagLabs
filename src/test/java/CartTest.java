import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;

    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
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
    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}


