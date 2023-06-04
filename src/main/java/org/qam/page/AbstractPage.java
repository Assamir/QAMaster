package org.qam.page;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qam.conf.TestContext;

import java.time.Duration;

public abstract class AbstractPage {
    protected String URL;
    protected String BaseAPI;
    protected WebDriver webDriver;
    protected RequestSpecification requestSpecification;


    protected AbstractPage(String url, String baseAPI, TestContext testContext) {
        this.URL = url;
        webDriver = testContext.getWebDriver();
        this.BaseAPI = baseAPI;
        requestSpecification = RestAssured.given().header("Content-type", "application/json").baseUri(baseAPI);
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }

    public String getBaseAPI() {
        return BaseAPI;
    }

    protected abstract AbstractPage setBaseAPI(String baseAPI);
    protected AbstractPage setBaseAPIInternal(String baseAPI) {
        BaseAPI = baseAPI;
        return this;
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
    var wait = new FluentWait<>(webDriver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(NoSuchElementException.class);

    try {
      wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
//      new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    catch (TimeoutException e){
      System.out.println("Element not found " + by);
    }
    return webDriver.findElement(by);
  }

}
