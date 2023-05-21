package amazon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.qam.conf.Browser;
import org.qam.conf.ScenarioContext;
import org.qam.conf.TestContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicTest {

  ScenarioContext scenarioContext;

  @BeforeAll
  void setUp(){
    scenarioContext = new ScenarioContext(false, Browser.CHROME);
  }

  @Test
  void basicSearch(){
    var testContext = scenarioContext.createTestContext();
    var pageManager = testContext.getPage();
    pageManager.searchBar()
        .setPhrase("Razer")
        .clickSearch();
  }
}
