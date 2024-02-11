package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static String[] headingsQuestions = {
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    };
    public String getHeadingXpath(String heading) {
        switch (heading) {
            case "accordion__heading-0":
                return ".//div[@id='accordion__panel-0']/p";
            case "accordion__heading-1":
                return ".//div[@id='accordion__panel-1']/p";
            case "accordion__heading-2":
                return ".//div[@id='accordion__panel-2']/p";
            case "accordion__heading-3":
                return ".//div[@id='accordion__panel-3']/p";
            case "accordion__heading-4":
                return ".//div[@id='accordion__panel-4']/p";
            case "accordion__heading-5":
                return ".//div[@id='accordion__panel-5']/p";
            case "accordion__heading-6":
                return ".//div[@id='accordion__panel-6']/p";
            case "accordion__heading-7":
                return ".//div[@id='accordion__panel-7']/p";
            default:
                return "";
        }
    }

    public String getExpectedQuestionText(String heading) {
        switch (getHeadingXpath(heading)) {
            case ".//div[@id='accordion__panel-0']/p":
                return "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
            case ".//div[@id='accordion__panel-1']/p":
                return "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
            case ".//div[@id='accordion__panel-2']/p":
                return "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
            case ".//div[@id='accordion__panel-3']/p":
                return "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
            case ".//div[@id='accordion__panel-4']/p":
                return "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
            case ".//div[@id='accordion__panel-5']/p":
                return "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
            case ".//div[@id='accordion__panel-6']/p":
                return "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
            case ".//div[@id='accordion__panel-7']/p":
                return "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
            default:
                return "";
        }
    }

    public OrderPage openOrderPageInHeader() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        return new OrderPage(driver);
    }

    public OrderPage openOrderPageInBody() {
        driver.findElement(By.className("Button_Middle__1CSJM")).click();
        return new OrderPage(driver);
    }

    public String getQuestionsAboutImportant(String heading) {
        By locator = By.id(heading);
        scrollToItem(locator);
        driver.findElement(locator).click();
        return driver.findElement(By.xpath(getHeadingXpath(heading))).getText();
    }

    private void scrollToItem(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofMillis(1000L))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
