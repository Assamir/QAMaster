import conf.Browser;
import conf.ScenarioContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SeleniumTest {

    ScenarioContext scenarioContext;

    @BeforeAll
    void setup() {
        scenarioContext = new ScenarioContext(false, Browser.CHROME);
    }

    @Test
    void flowTest() {
        var testContext = scenarioContext.createTestContext();
        var pageManager = testContext.getPage();
        var homePage = pageManager.login();
        homePage.navigateToStartPage();
        homePage.loginAsUser()
                .enterScoreCard();

        pageManager.scoreCard().
                scoreSequence(List.of(1, 5, 9, 6, 10)).saveCard().
                scoreSequence(List.of(3, 4, 9, 2, 3)).saveCard();

        testContext.finish();
    }
}
