import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage{

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(className = "summary_subtotal_label")
    WebElement itemtotal;

    @FindBy(css = ".summary_total_label")
    WebElement total;

    @FindBy(id = "finish")
    WebElement finish;

    @FindBy(className = "complete-header")
    WebElement infoMessage;

    public CheckoutStepOnePage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void inputPersonalInfo(String name,String last,String zip)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        postalCode.sendKeys(zip);
        continueButton.click();
    }

    public String getItemTotal(){
        return itemtotal.getText();
    }

    public String getTotal(){
        return total.getText();
    }

    public void clickFinish()
    {
        finish.click();
    }

    public String getInfoMessage()
    {
        return infoMessage.getText();
    }
}
