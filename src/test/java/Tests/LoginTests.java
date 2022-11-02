package Tests;

import Base.BaseTest;
import Resources.Constants;
import PageObject.PageFunctions.LoginPageFunctions;
import PageObject.PageFunctions.TradingPageFunctions;
import Resources.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {
    @BeforeMethod
    public void setUp() {
        BaseTest.initialize();
        BaseTest.openurl(Constants.BASE_URL);
    }

    @AfterMethod
    public void tearDown(){
        BaseTest.quit();
    }

    @Test(description = "Successfully login test", dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
    public void loginSuccess(String name, String pass) {
        LoginPageFunctions login = new LoginPageFunctions(driver);
        Assert.assertEquals(login.isHeaderDisplayed(), true);
        login.fillLoginFields(name, pass);

        TradingPageFunctions tradingPage = new TradingPageFunctions(driver);
        Assert.assertEquals(tradingPage.isLogoutDisplayed(), true);
    }

    @Test(description = "Unsuccessful login test", dataProvider = "wrong credentials", dataProviderClass = DataProviderClass.class)
    public void loginFail(String name, String pass) {
        LoginPageFunctions login = new LoginPageFunctions(driver);
        Assert.assertEquals(login.isHeaderDisplayed(), true);
        login.fillLoginFields(name, pass);
        Assert.assertEquals(login.isErrorDisplayed(), true);
    }
}
