
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeConnection {

    static String pageName = "https://qa-scooter.praktikum-services.ru/";
    static Cookie[] cartochka = {
            new Cookie("Cartoshka","true"),
            new Cookie("Cartoshka-legacy","true")
    };

    WebDriver driver;

    @Before
    public void openChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
