import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(className = "inventory_item_price")
    WebElement price;

    @FindBy(className = "inventory_item_name")
    WebElement nameOfProduct;
    @FindBy(className = "shopping_cart_badge")
    WebElement cart;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeTshirt;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeLight;

   // @FindBy(id = "react-burger-menu-btn")
  //  WebElement burger;

  //  @FindBy(id = "inventory_sidebar_link")
   // WebElement allitems;

    @FindBy(id = "continue-shopping")
    WebElement continueshopp;

    @FindBy(name = "checkout")
    WebElement checkoutButton;

    public CartPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getInfoPrice()
    {
        return  price.getText();
}

    public String getCartNumber()
    {
        return cart.getText();
    }

    public void removeTshirt()
    {
        removeTshirt.click();
    }
    public void removeLight()
    {
        removeLight.click();
    }

  //  public void clickBurger(){burger.click();}

   // public void clickAllItems(){allitems.click();}
    public void clickContinueShopp(){continueshopp.click();}

    public String getProductName()
    {
        return nameOfProduct.getText();
    }

    public void clickCheckout()
    {
        checkoutButton.click();
    }

}