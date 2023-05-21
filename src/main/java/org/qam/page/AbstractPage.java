package org.qam.page;

import org.qam.conf.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

  private WebElement getWebElement(By by) {
    new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    return webDriver.findElement(by);
  }

}
