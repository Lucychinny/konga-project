import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KongaLoginPage {
    WebDriver Ldriver ;

    public KongaLoginPage(WebDriver driver){
        Ldriver = driver;
        PageFactory.initElements(Ldriver, this);
    }
    @FindBy(xpath = "//input[@id='username']")
    private WebElement login;

    public WebElement getLogin() {
        return login;
    }
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    public WebElement getPassword() {
        return password;
    }
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    public WebElement getLoginButton() {
        return loginButton;
    }
}

