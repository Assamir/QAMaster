package org.qam.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qam.conf.TestContext;

import java.time.Duration;

public abstract class AbstractPage {
  protected static final String URL = "https://www.amazon.pl";
  protected WebDriver webDriver;

  protected AbstractPage(TestContext testContext) {
    webDriver = testContext.getWebDriver();
  }

  public void navigateToStartPage() {
    webDriver.get(URL);
  }

  protected AbstractPage click(By by) {
    getWebElement(by).click();
    return this;
  }

  protected AbstractPage setTextInputField(By by, String text) {
    getWebElement(by).sendKeys(text);
    return this;
  }

  protected String getValue(By by) {
    try {
      getWebElement(by).getText();
    } catch (TimeoutException | NoSuchElementException e) {
      System.out.println("Element not found: " + by);
    }
    return getWebElement(by).getText();
  }

  private WebElement getWebElement(By by) {
    try {
      new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    catch (TimeoutException e){
      System.out.println("Element not found " + by);
    }
    return webDriver.findElement(by);
  }

}
