package org.qam.conf;


import org.qam.page.AbstractPage;
import org.qam.page.HomePage;
import org.qam.page.ScoreCard;

import java.util.HashMap;
import java.util.Map;

public class PageManager {
  private Map<Page, AbstractPage> pageMap = new HashMap<>();
  private TestContext testContext;

  public PageManager(TestContext testContext) {
    this.testContext = testContext;
  }

  public HomePage login(){
    return (HomePage) getPage(Page.LOGIN);
  }

  public ScoreCard scoreCard(){
    return (ScoreCard) getPage(Page.SCORE_CARD);
  }

  private AbstractPage getPage(Page page) {
    switch (page) {
      case LOGIN -> {
        return pageMap.containsKey(page) ? pageMap.get(page) : pageMap.computeIfAbsent(page, k -> new HomePage(testContext));
      }
      case SCORE_CARD -> {
        return pageMap.containsKey(page) ? pageMap.get(page) : pageMap.computeIfAbsent(page, k -> new ScoreCard(testContext));
      }
      default -> {
        throw new RuntimeException("Missing page object: " + page);
      }
    }
  }

}
