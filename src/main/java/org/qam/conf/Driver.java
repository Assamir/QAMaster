package org.qam.conf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driver {
  private Driver() {
  }
  public static WebDriver get(boolean headless, Browser browser){
    WebDriverManager.chromedriver().setup();

    var options = Browser.CHROME.equals(browser) ? new ChromeOptions() : new EdgeOptions();
    if(headless) options.addArguments("--headless=new");
    return Browser.CHROME.equals(browser) ? getChromeDriver((ChromeOptions) options) : getEdgeDriver((EdgeOptions) options);
  }

  private static EdgeDriver getEdgeDriver(EdgeOptions options) {
    WebDriverManager.edgedriver().setup();
    return new EdgeDriver(options);
  }

  private static ChromeDriver getChromeDriver(ChromeOptions options) {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver(options);
  }

}
