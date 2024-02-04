import org.example.HomePage;
import org.example.OrderDataTest;
import org.example.OrderPage;
import org.example.OrderPageComplete;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SamokatTestCase {

  WebDriver driver;

  public SamokatTestCase(WebDriver driver) {
    this.driver = driver;
  }

  static OrderDataTest orderDataTest = new OrderDataTest("Иван", "Иванов", "Москва", "Технопарк", "89991234567", "01.03.2024", 1, "black", "Тестовый комментарий");
  static OrderDataTest orderDataTest1 = new OrderDataTest("Петр", "Петров", "Москва", "Технопарк", "89991234511", "02.03.2024", 2, "gray", "Тесто");


  public void checkTextInQuestionsTest() {
    HomePage homePage = new HomePage(driver);
    for (String heading : HomePage.headings) {
      assertEquals(
          homePage.getQuestionsAboutImportant(heading),
          homePage.getExpectedQuestionText(heading)
      );
    }
  }

  public void makeOrderTestInHeaderTest() {
    HomePage homePage = new HomePage(driver);
    OrderPage orderPage = homePage.openOrderPageInHeader();
    OrderPageComplete orderPageComplete = orderPage.makeOrder(orderDataTest);
    assertTrue(orderPageComplete.isFinished());
  }

  public void makeOrderTestInBodyTest() {
    HomePage homePage = new HomePage(driver);
    OrderPage orderPage = homePage.openOrderPageInBody();
    OrderPageComplete orderPageComplete = orderPage.makeOrder(orderDataTest);
    assertTrue(orderPageComplete.isFinished());
  }

  public void makeOrderTestInBodyAnotherData() {
    HomePage homePage = new HomePage(driver);
    OrderPage orderPage = homePage.openOrderPageInBody();
    OrderPageComplete orderPageComplete = orderPage.makeOrder(orderDataTest1);
    assertTrue(orderPageComplete.isFinished());
  }
}

