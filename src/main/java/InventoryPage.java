import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement onesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement light;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tshirt;


    @FindBy(className = "product_sort_container")
    WebElement sort;

    @FindBy(className = "inventory_item_price")
    WebElement price;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeTshirt;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeLight;
    @FindBy(id = "shopping_cart_container")
    WebElement cart;





    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addOnesie()
    {
        onesie.click();
    }
    public void addLight()
    {
        light.click();
    }

    public void addTshirt()
    {
        tshirt.click();
    }

    public void sortProducts(String text)
    {
        Select select = new Select(sort);
        select.selectByVisibleText(text);
    }

    public String getPrice()
    {
        return price.getText();
    }

    public String getCartNumber()
    {
        return cart.getText();
    }


    public void clickOnCart()
    {
        cart.click();}


}
