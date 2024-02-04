import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxConnection {

    static String pageName = "https://qa-scooter.praktikum-services.ru/";
    static Cookie[] cartochka = {
            new Cookie("Cartoshka","true"),
            new Cookie("Cartoshka-legacy","true")
    };

    WebDriver driver;

    @Before
    public void openFirefox() {
        System.setProperty("webdriver.gecko.driver", "/Users/ekaterina/WebDriver/geckodriver");
        driver = new FirefoxDriver();
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
}
