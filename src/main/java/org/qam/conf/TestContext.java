package org.qam.conf;

import com.microsoft.playwright.Browser;
import org.qam.api.APIManager;
import org.qam.page.amazon.PageManager;

import java.util.logging.Logger;

public class TestContext {
  private static final Logger logger = Logger.getLogger(TestContext.class.getName());
  private ScenarioContext scenarioContext;
  private final String id;
  private final Browser browser;
  private final long startTime;
  private PageManager pageManager;

  private APIManager apiManager;
  private String callingClassName = "";
  private String callingMethodName = "";

  public TestContext(ScenarioContext scenarioContext) {
    var nanoTime = System.nanoTime();
    this.scenarioContext = scenarioContext;

    id = String.valueOf(nanoTime);
    startTime = nanoTime;
    browser = init(scenarioContext.isHeadless());
    pageManager = new PageManager(this);
//    apiManager = new APIManager(this, RestAssured.requestSpecification);
    logger.info(id);
  }

  public String getId() {
    return id;
  }

  public Browser getBrowser() {
    return browser;
  }

  private Browser init(boolean headless) {
    return BrowserDriver.get(headless, scenarioContext);
  }

  public void finish() {
    long finishTime = System.nanoTime();
    closeBrowser();
    browser.close();
    logger.info(String.format("Time taken for %s.%s: %ss", callingClassName, callingMethodName, ((finishTime - startTime) / 1_000_000_000.0)));
  }

  public PageManager getPageManager() {
    var stackTrace = new Throwable().getStackTrace();
    callingClassName = stackTrace[1].getClassName();
    callingMethodName = stackTrace[1].getMethodName();

    return pageManager;
  }

  public ScenarioContext getScenarioContext() {
    return scenarioContext;
  }

  private void closeBrowser() {
    browser.close();
  }
}
