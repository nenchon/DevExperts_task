package PageObject.PageElements;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login-title")
    protected WebElement loginHeader;

    @FindBy(id = "name")
    protected WebElement username;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "login-button")
    protected WebElement loginBtn;

    @FindBy(id = "login-status")
    protected WebElement loginError;
}
