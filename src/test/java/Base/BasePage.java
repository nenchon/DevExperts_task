package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Base.BaseTest.driver;

public class BasePage extends PageFactory {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitDisappear(WebElement element) throws Error{
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOf(element));
    }
}
