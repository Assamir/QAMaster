package org.qam.conf;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.logging.Logger;

public class BrowserDriver {
  private static final Logger logger = Logger.getLogger(BrowserDriver.class.getName());
  private BrowserDriver() {
  }
  public static Browser get(boolean headless, ScenarioContext scenarioContext){
    var options = new BrowserType.LaunchOptions();
    options.headless = headless;

    var browserToRun = scenarioContext.getBrowser();
    switch (browserToRun){
      case CHROME -> {
        options.setChannel("chrome");
        return getChromium(scenarioContext.getPlaywright(), options);
      }
      case EDGE -> {
        options.setChannel("msedge");
        return getChromium(scenarioContext.getPlaywright(), options);
      }
      case FIREFOX -> {
        return getFirefox(scenarioContext.getPlaywright(), options);
      }
      case WEBKIT -> {
        return getWebkit(scenarioContext.getPlaywright(), options);
      }
      default -> {
        var msg = String.format("Web driver not found for %s, running Chromium", browserToRun);
        logger.warning(msg);
        return getChromium(scenarioContext.getPlaywright(), options);
      }
    }


  }

  private static Browser getChromium(Playwright playwright, BrowserType.LaunchOptions options) {
    return playwright.chromium().launch(options);
  }

  private static Browser getFirefox(Playwright playwright, BrowserType.LaunchOptions options) {
    return playwright.firefox().launch(options);
  }
  private static Browser getWebkit(Playwright playwright, BrowserType.LaunchOptions options) {
    return playwright.webkit().launch(options);
  }

}
