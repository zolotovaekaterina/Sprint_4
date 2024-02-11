package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage openOrderPageInHeader() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        return new OrderPage(driver);
    }

    public OrderPage openOrderPageInBody() {
        driver.findElement(By.className("Button_Middle__1CSJM")).click();
        return new OrderPage(driver);
    }
}
