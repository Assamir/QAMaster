package conf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class TestContext {
  private static final Logger logger = Logger.getLogger(TestContext.class.getName());
  private ScenarioContext scenarioContext;
  private final String id;
  private final WebDriver webDriver;
  private final long startTime;
  private PageManager pageManager;
  private String callingClassName = "";
  private String callingMethodName = "";

  public TestContext(ScenarioContext scenarioContext) {
    var nanoTime = System.nanoTime();
    this.scenarioContext = scenarioContext;
    id = String.valueOf(nanoTime);
    startTime = nanoTime;
    webDriver = init(scenarioContext.isHeadless());
    pageManager = new PageManager(this);
    logger.info(id);
  }

  public String getId() {
    return id;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  private WebDriver init(boolean headless) {
    return Driver.get(headless, scenarioContext.getBrowser());
  }

  public void finish() {
    long finishTime = System.nanoTime();
    closeBrowser();
    webDriver.quit();
    logger.info(String.format("Time taken for %s.%s: %ss", callingClassName, callingMethodName, ((finishTime - startTime) / 1_000_000_000.0)));
  }

  public PageManager getPage() {
    var stackTrace = new Throwable().getStackTrace();
    callingClassName = stackTrace[1].getClassName();
    callingMethodName = stackTrace[1].getMethodName();

    return pageManager;
  }

  private void closeBrowser() {
    webDriver.close();
  }
}
