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
        scenarioContext = new ScenarioContext(false, BrowserToRun.CHROME);
    }

    @TestConfiguration(testPriority = TestPriority.HIGH, testTypes = {TestType.UNIT, TestType.INTEGRATION})
    void basicSearch() {
        var testContext = scenarioContext.createTestContext();
        var pageManager = testContext.getPageManager();
        pageManager.searchBar()
                .setPhrase("Razer")
                .clickSearch();
        testContext.finish();
        var planets = testContext.getApiManager().Planets().getPlanets();
        logger.info("planets.size: " + planets.size());
        logger.info("planets" + planets.toString());
        for(var planet:  planets){
            logger.info("planet.name: " + planet.getName());
            logger.info("planet.url: " + planet.getUrl());
        }
    }
}
