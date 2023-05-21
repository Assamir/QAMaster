package org.qam.common;

import org.openqa.selenium.By;
import org.qam.conf.TestContext;
import org.qam.page.AbstractPage;

public class SearchBar extends AbstractPage {

  public SearchBar(TestContext testContext) {
    super(testContext);
  }

  public SearchBar setPhrase(String phrase){
    setTextInputField(By.cssSelector("#nav-bb-search"), phrase);
    return this;
  }

  public SearchBar clickSearch(){
    click(By.className("nav-bb-button"));
    return this;
  }
}
