
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserConnection {

    static String pageName = "https://qa-scooter.praktikum-services.ru/";
    static Cookie[] cartochka = {
            new Cookie("Cartoshka","true"),
            new Cookie("Cartoshka-legacy","true")
    };

    WebDriver driver;

    @Before
    public void openChrome() {

        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        openPage(pageName);
        setCookies(cartochka);
    }

    private void setCookies(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }

    private void openPage(String url) {
        driver.get(url);
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        String driverType = System.getenv("BROWSER");

        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/ekaterina/WebDriver/geckodriver");
                return new FirefoxDriver();
        }

         return null;
    }

    public void scrollToItem(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofMillis(1000L))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
