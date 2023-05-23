package org.qam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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

    private WebElement getWebElement(By by) {
        var wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));


        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return webDriver.findElement(by);
    }

}
