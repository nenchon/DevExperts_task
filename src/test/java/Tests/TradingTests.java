package Tests;

import Base.BaseTest;
import PageObject.PageFunctions.LoginPageFunctions;
import PageObject.PageFunctions.TradingPageFunctions;
import Resources.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TradingTests extends BaseTest {
    private float balance;

    @BeforeMethod
    public void setUp() {
        BaseTest.initialize();
        BaseTest.openurl(Constants.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This test is flaky - sometimes refresh of the wallet amount is too slow
    @Test
    public void buyCoins() {
        float ccAmount;
        float ccAmountAfterBuy;
        LoginPageFunctions login = new LoginPageFunctions(driver);
        TradingPageFunctions trading = login.login("nenchon@gmail.com", "P@swword1");
        balance = trading.getBalance();
        System.out.println(balance);

        trading.expandCCinfo();
        ccAmount = trading.getCCAmount();

        trading.buyCoin("CC");
        trading.expandCCinfo();
        ccAmountAfterBuy = trading.getCCAmount();
        System.out.println(ccAmount);
        System.out.println(ccAmountAfterBuy);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertNotEquals(ccAmountAfterBuy, ccAmount);
    }

    @Test
    public void sellCoins() throws InterruptedException {
        float ccAmount;
        float ccAmountAfterBuy;
        LoginPageFunctions login = new LoginPageFunctions(driver);
        TradingPageFunctions trading = login.login("nenchon@gmail.com", "P@swword1");
        balance = trading.getBalance();
        System.out.println(balance);

        trading.expandCCinfo();
        ccAmount = trading.getCCAmount();

        trading.sellCoin("CC");
        trading.expandCCinfo();
        ccAmountAfterBuy = trading.getCCAmount();
        System.out.println(ccAmount);
        System.out.println(ccAmountAfterBuy);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertNotEquals(ccAmountAfterBuy, ccAmount);
    }

}
