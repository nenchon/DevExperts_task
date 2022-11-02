package PageObject.PageFunctions;

import PageObject.PageElements.LoginPage;
import org.openqa.selenium.WebDriver;

import static Base.BaseTest.driver;

public class LoginPageFunctions extends LoginPage {

    public LoginPageFunctions(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return loginHeader.isDisplayed();
    }

    public boolean isErrorDisplayed() {
        waitForVisibility(loginError);
        return loginError.isDisplayed();
    }

    public void fillLoginFields(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        loginClick();
    }

    public TradingPageFunctions login(String user, String pass) {
        fillLoginFields(user, pass);
        return new TradingPageFunctions(driver);
    }

    private void enterUsername(String user) {
        username.sendKeys(user);
    }

    private void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    private void loginClick() {
        loginBtn.click();
    }


}
