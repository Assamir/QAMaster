package org.qam.conf;


import org.qam.common.SearchBar;
import org.qam.page.AbstractPage;
import org.qam.page.HomePage;
import org.qam.page.Navigator;
import org.qam.page.ScoreCard;

import java.util.HashMap;
import java.util.Map;

public class PageManager {
  private Map<Page, AbstractPage> pageMap = new HashMap<>();
  private TestContext testContext;

  public PageManager(TestContext testContext) {
    this.testContext = testContext;
    navigate().navigateToStartPage();
  }

  public HomePage login(){
    return (HomePage) getPage(Page.LOGIN);
  }
  private Navigator navigate(){
    return (Navigator) getPage(Page.NAVIGATOR);
  }

  public SearchBar searchBar(){
    return (SearchBar) getPage(Page.SEARCH_BAR);
  }

  private AbstractPage getPage(Page page) {
    switch (page) {
      case NAVIGATOR -> {
        return pageMap.containsKey(page) ? pageMap.get(page) : pageMap.computeIfAbsent(page, k -> new Navigator(testContext));
      }
      case LOGIN -> {
        return pageMap.containsKey(page) ? pageMap.get(page) : pageMap.computeIfAbsent(page, k -> new HomePage(testContext));
      }
      case SEARCH_BAR -> {
        return pageMap.containsKey(page) ? pageMap.get(page) : pageMap.computeIfAbsent(page, k -> new SearchBar(testContext));
      }
      default -> {
        throw new RuntimeException("Missing page object: " + page);
      }
    }
  }

}
