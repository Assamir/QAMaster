package amazon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.qam.annotation.TestConfiguration;
import org.qam.annotation.TestPriority;
import org.qam.annotation.TestType;
import org.qam.conf.Browser;
import org.qam.conf.ScenarioContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicTest {

    ScenarioContext scenarioContext;

    @BeforeAll
    void setUp() {
        scenarioContext = new ScenarioContext(false, Browser.CHROME);
    }

    @TestConfiguration(testPriority = TestPriority.HIGH, testTypes = {TestType.UNIT, TestType.INTEGRATION})
    void basicSearch() {
        var testContext = scenarioContext.createTestContext();
        var pageManager = testContext.getPageManager();
        pageManager.searchBar()
                .setPhrase("Razer")
                .clickSearch();
        testContext.finish();
    }
}
