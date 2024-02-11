package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageComplete {

    WebDriver driver;

    public OrderPageComplete(WebDriver driver) {
        this.driver = driver;
    }
    public Boolean isFinished() {
        return driver.findElement(By.xpath("//div[text()='Заказ оформлен']")).isDisplayed();
    }
}
