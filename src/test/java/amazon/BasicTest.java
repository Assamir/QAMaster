package amazon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.qam.annotation.TestConfiguration;
import org.qam.annotation.TestPriority;
import org.qam.annotation.TestType;
import org.qam.conf.BrowserToRun;
import org.qam.conf.ScenarioContext;

import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicTest {
    private static final Logger logger = Logger.getLogger(BasicTest.class.getName());

    ScenarioContext scenarioContext;

    @BeforeAll
    void setUp() {
        scenarioContext = new ScenarioContext(true, BrowserToRun.CHROME);
    }

    @TestConfiguration(testPriority = TestPriority.HIGH, testTypes = {TestType.CRITICAL_PATH})
    void basicWebSearch() {
        var testContext = scenarioContext.createTestContext();
        var pageManager = testContext.getPageManager();
        var fraze = "Razer";
        pageManager.searchBar()
                .setPhrase(fraze)
                .clickSearch();
        testContext.addStep("Searching for: " + fraze, true);
        testContext.finish();
        testContext.addStep("Finished UI part", true);
    }
}
