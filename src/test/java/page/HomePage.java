package page;

import conf.TestContext;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

  public HomePage(TestContext testContext) {
    super(testContext);
  }

  public HomePage loginAsUser() {
    click(By.cssSelector("#account-menu"));
    click(By.cssSelector("#login-item"));
    setTextInputField(By.id("username"), "user");
    setTextInputField(By.id("password"), "user");
    click(By.cssSelector(".btn-primary > span"));
    return this;
  }

  public HomePage enterScoreCard(){
    click(By.id("enter-scorecard-dessert"));
    return this;
  }
}
