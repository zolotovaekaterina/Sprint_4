package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderPage {

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPageComplete makeOrder(OrderDataTest orderDataTest) {
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys(orderDataTest.firstname);
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys(orderDataTest.lastname);
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(orderDataTest.address);
        selectStation(orderDataTest.subwayStation);
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(orderDataTest.telephone);
        driver.findElement(By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]")).click();
        selectOrderDate(orderDataTest.orderDate);
        selectRentalDay(orderDataTest.days);
        selectColor(orderDataTest.color);
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).sendKeys(orderDataTest.comment);
        driver.findElement(By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]")).click();
        driver.manage().timeouts()
                .implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[text()='Да']")).click();

        return new OrderPageComplete(driver);
    }

    private void selectOrderDate(String date) {
        driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']")).sendKeys(date);
        driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']")).sendKeys(Keys.ENTER);
    }

    private void selectStation(String subwayStation) {
        By selectSearch = By.className("select-search__input");
        driver.findElement(selectSearch).click();
        driver.findElement(selectSearch).sendKeys(subwayStation);
        driver.findElement(selectSearch).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    private void selectColor(String color) {
        if (color.equals("black")) {
            driver.findElement(By.xpath(".//input[@id='black']")).click();
        } else if (color.equals("grey")) {
            driver.findElement(By.xpath(".//input[@id='grey']")).click();
        }
    }

    private void selectRentalDay(int day) {
        driver.findElement(By.className("Dropdown-placeholder")).click();
        String xpath = String.format(".//*[@class='Dropdown-option'][%d]", day);
        driver.findElement(By.xpath(xpath)).click();
    }
}
