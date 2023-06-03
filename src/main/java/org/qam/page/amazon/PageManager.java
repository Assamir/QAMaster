package org.qam.page.amazon;


import org.qam.page.AbstractPageManager;
import org.qam.page.amazon.common.SearchBar;
import org.qam.conf.TestContext;
import org.qam.page.AbstractPage;

public class PageManager extends AbstractPageManager {
//    private Map<AmazonPage, AbstractPage> pageMap = new HashMap<>();
//    private TestContext testContext;

  public PageManager(TestContext testContext) {
    super(testContext);
  }

    public HomePage login() {
        return (HomePage) getPage(AmazonIPage.LOGIN);
    }

    private Navigator navigate() {
        return (Navigator) getPage(AmazonIPage.NAVIGATOR);
    }

    public SearchBar searchBar() {
        return (SearchBar) getPage(AmazonIPage.SEARCH_BAR);
    }

    private AbstractPage getPage(AmazonIPage amazonPage) {
        switch (amazonPage) {
            case NAVIGATOR -> {
                return pageMap.containsKey(amazonPage) ? pageMap.get(amazonPage) : pageMap.computeIfAbsent(amazonPage, k -> new Navigator(testContext));
            }
            case LOGIN -> {
                return pageMap.containsKey(amazonPage) ? pageMap.get(amazonPage) : pageMap.computeIfAbsent(amazonPage, k -> new HomePage(testContext));
            }
            case SEARCH_BAR -> {
                return pageMap.containsKey(amazonPage) ? pageMap.get(amazonPage) : pageMap.computeIfAbsent(amazonPage, k -> new SearchBar(testContext));
            }
            default -> {
                throw new RuntimeException("Missing page object: " + amazonPage);
            }
        }
    }

  @Override
  protected void navigateToStartPage() {
    navigate().navigateToStartPage();
  }
}
