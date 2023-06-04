package org.qam.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.qam.conf.TestContext;

import java.time.Duration;

public abstract class AbstractPage {

    protected Page page;
    protected String URL;
    protected String BaseAPI;
    protected Browser browser;
//    protected RequestSpecification requestSpecification;


    protected AbstractPage(String url, String baseAPI, TestContext testContext) {
        this.browser = testContext.getBrowser();
        this.page = browser.newPage();
        this.URL = url;
        this.BaseAPI = baseAPI;
//        requestSpecification = RestAssured.given().header("Content-type", "application/json").baseUri(baseAPI);
    }

//    public RequestSpecification getRequestSpecification(){
//        return requestSpecification;
//    }

    public String getBaseAPI() {
        return BaseAPI;
    }

    protected abstract AbstractPage setBaseAPI(String baseAPI);
    protected AbstractPage setBaseAPIInternal(String baseAPI) {
        BaseAPI = baseAPI;
        return this;
    }

    public void navigateToStartPage() {
        page.navigate(URL);
    }

    protected AbstractPage click(AriaRole ariaRole, String selector) {
        getWebElement(ariaRole, selector).click();
        return this;
    }

    protected AbstractPage setTextInputField(AriaRole ariaRole, String selector, String text) {
        getWebElement(ariaRole, selector).fill(text);
        return this;
    }

  protected String getValue(AriaRole ariaRole, String selector) {
    return getWebElement(ariaRole, selector).innerText();
  }

  private Locator getWebElement(AriaRole ariaRole, String selector) {
    switch (ariaRole){
        default -> {
            return page.locator(selector);
        }
    }
  }

}
