package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    public static WebDriver initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void quit() {
        driver.quit();
    }

    public static void close() {
        driver.close();
    }

    public  static void openurl(String URL)
    {
        driver.get(URL);
    }
}
