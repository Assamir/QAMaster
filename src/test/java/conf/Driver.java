package conf;

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
    if(!headless) options.addArguments("--headless=new");
    return Browser.CHROME.equals(browser) ? new ChromeDriver((ChromeOptions) options) : new EdgeDriver((EdgeOptions) options);
  }

}
