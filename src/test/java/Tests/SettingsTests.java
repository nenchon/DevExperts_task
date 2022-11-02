package Tests;

import Base.BaseTest;
import PageObject.PageFunctions.LoginPageFunctions;
import PageObject.PageFunctions.TradingPageFunctions;
import Resources.Constants;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsTests extends BaseTest {
    @BeforeMethod
    public void setUp() {
        BaseTest.initialize();
        BaseTest.openurl(Constants.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void changeColorSchemeToDark() throws InterruptedException {
        String backgroundColor;
        LoginPageFunctions login = new LoginPageFunctions(driver);
        TradingPageFunctions trading = login.login("nenchon@gmail.com", "P@swword1");

        trading.changeSchemeColor("dark");
        backgroundColor = trading.getBackgroundColor();
        Assert.assertEquals(backgroundColor, Constants.DARK_BACKGROUND_COLOR);
    }

    @Test
    public void changeColorSchemeToLight() throws InterruptedException {
        String backgroundColor;
        LoginPageFunctions login = new LoginPageFunctions(driver);
        TradingPageFunctions trading = login.login("nenchon@gmail.com", "P@swword1");

        trading.changeSchemeColor("light");
        backgroundColor = trading.getBackgroundColor();
        Assert.assertEquals(backgroundColor, Constants.LIGHT_BACKGROUND_COLOR);
    }
}
