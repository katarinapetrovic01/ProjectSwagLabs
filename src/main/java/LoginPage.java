import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement pass;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void LoginOnPage(String name,String password)
    {
        userName.sendKeys(name);
        pass.sendKeys(password);
        loginButton.submit();
    }
}
