package PageObject.PageFunctions;

import Base.BasePage;
import PageObject.PageElements.TradingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TradingPageFunctions extends TradingPage {
    public TradingPageFunctions(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutDisplayed() {
        waitForVisibility(logout);
        return logout.isDisplayed();
    }

    public boolean isSellCCBtnEnabled() {
        return sellCCBtn.isEnabled();
    }

    public boolean isSellGLCBtnEnabled() {
        return sellGLCBtn.isEnabled();
    }

    public float getBalance() {
        waitForVisibility(balanceAmount);
        return Float.parseFloat(balanceAmount.getText());
    }

    public void expandCCinfo() {
        if (!ccAmount.isDisplayed()) {
            positionCollection.get(0).findElement(By.cssSelector("div[class='itable symbolToggle']")).click();
            waitForVisibility(ccAmount);
        }
    }

    public float getCCAmount() {
        waitForVisibility(ccAmount);
        return Float.parseFloat(ccAmount.getText());
    }

    public void buyCoin(String coinType) {
        switch (coinType) {
            case "CC":
                buyCCBtn.click();
                break;
            case "GLC":
                buyGLCBtn.click();
                break;
            default:
                Assert.fail("This coin type is not supported");
        }
        waitForVisibility(orderForm);
        Assert.assertEquals(coinType, orderSymbol.getAttribute("value"), "Incorrect coin");
        if (Integer.parseInt(orderAmount.getAttribute("value")) > 0) {
            orderBuyBtn.click();
            waitDisappear(orderForm);
        } else {
            Assert.fail("Cannot buy");
        }
    }

    public void sellCoin(String coinType) {
        switch (coinType) {
            case "CC":
                if (isSellCCBtnEnabled()) {
                    sellCCBtn.click();
                    break;
                } else {
                    Assert.fail("Cannot sell");
                }
            case "GLC":
                if (isSellGLCBtnEnabled()) {
                    sellGLCBtn.click();
                    break;
                } else {
                    Assert.fail("Cannot sell");
                }
            default:
                Assert.fail("This coin type is not supported");
        }
        waitForVisibility(orderForm);
        Assert.assertEquals(coinType, orderSymbol.getAttribute("value"), "Incorrect coin");
        if (Integer.parseInt(orderAmount.getAttribute("value")) > 0) {
            orderBuyBtn.click();
            waitDisappear(orderForm);
        } else {
            Assert.fail("Cannot buy");
        }
    }

    public void changeSchemeColor(String scheme) {
        waitForVisibility(settingsBtn);
        settingsBtn.click();
        waitForVisibility(settingsSystemTab);
        settingsSystemTab.click();
        waitForVisibility(settingsColorSchemeDropDown);
        settingsColorSchemeDropDown.click();
        Select selection = new Select(settingsColorSchemeDropDown);
        if (scheme.equals("dark")) {
            //waitForVisibility(settingsDarkScheme);
            selection.selectByValue("DARK");
        } else if (scheme.equals("light")) {
            //waitForVisibility(settingsLightScheme);
            selection.selectByValue("LIGHT");
        }
        acceptChanges();
    }

    public void closeModal() {
        closeModalBtn.click();
        waitForVisibility(settingsBtn);
    }

    public void acceptChanges() {
        acceptChanges.click();
        waitForVisibility(settingsBtn);
    }

    public String getBackgroundColor() {
        return tradingPage.getCssValue("color");
    }
}
