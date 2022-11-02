package PageObject.PageElements;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class TradingPage extends BasePage {

    public TradingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "trading-page")
    protected WebElement tradingPage;

    @FindBy(id = "logout-button")
    protected WebElement logout;

    @FindBy(id = "balanceInfoNumber")
    protected WebElement balanceAmount;

    @FindBy(id = "BUY_CC")
    protected WebElement buyCCBtn;

    @FindBy(id = "SELL_CC")
    protected WebElement sellCCBtn;

    @FindBy(id = "BUY_GLC")
    protected WebElement buyGLCBtn;

    @FindBy(id = "SELL_GLC")
    protected WebElement sellGLCBtn;

    @FindBy(id = "amount_CC")
    protected WebElement ccAmount;

    @FindBy(id = "amount_GLC")
    protected WebElement glcAmount;

    @FindBys({@FindBy(className = "position-entry")})
    protected List<WebElement> positionCollection;

    @FindBy(id = "orderEntry")
    protected WebElement orderForm;

    @FindBy(id = "orderSymbol")
    protected WebElement orderSymbol;

    @FindBy(id = "orderConfirm")
    protected WebElement orderBuyBtn;

    @FindBy(id = "orderAmount")
    protected WebElement orderAmount;

    @FindBy(id = "settings-button")
    protected WebElement settingsBtn;

    @FindBy(id = "userSettings")
    protected WebElement settingsForm;

    @FindBy(id = "system-tab")
    protected WebElement settingsSystemTab;

    @FindBy(id = "colorScheme")
    protected WebElement settingsColorSchemeDropDown;

    @FindBy(id = "user-cscheme-light")
    protected WebElement settingsLightScheme;

    @FindBy(id = "user-cscheme-dark")
    protected WebElement settingsDarkScheme;

    @FindBy(className = "modal-close")
    protected WebElement closeModalBtn;

    @FindBy(id = "user-settings-submit")
    protected WebElement acceptChanges;
}
