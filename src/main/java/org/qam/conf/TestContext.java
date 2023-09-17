package org.qam.conf;

import com.microsoft.playwright.Browser;
import org.qam.api.APIManager;
import org.qam.entity.TestFlow;
import org.qam.entity.TestStep;
import org.qam.page.amazon.PageManager;
import org.qam.service.TestFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Component
public class TestContext {
    private static final Logger logger = Logger.getLogger(TestContext.class.getName());

    @Autowired
    private TestFlowService testFlowService;
    private ScenarioContext scenarioContext;
    private String id;
    private Browser browser;
    private long startTime;
    private PageManager pageManager;

    private APIManager apiManager;
    private String callingClassName = "";
    private String callingMethodName = "";

    private TestFlow testFlow = new TestFlow();
    private List<TestStep> testStepList = new ArrayList<>();


    public TestContext() {
    }

    @Autowired
    public TestContext(TestFlowService testFlowService) {
        this.testFlowService = testFlowService;
    }

    public TestContext(ScenarioContext scenarioContext) {
        init(scenarioContext);
    }

    public void init(ScenarioContext scenarioContext) {
        var nanoTime = System.nanoTime();
        this.scenarioContext = scenarioContext;

        id = String.valueOf(nanoTime);
        startTime = nanoTime;
        browser = init(scenarioContext.isHeadless());
        pageManager = new PageManager(this);
//    apiManager = new APIManager(this, RestAssured.requestSpecification);
        apiManager = new APIManager(this);
        logger.info(id);
    }

    public String getId() {
        return id;
    }

    public Browser getBrowser() {
        return browser;
    }

    private Browser init(boolean headless) {
        return BrowserDriver.get(headless, scenarioContext);
    }

    public TestContext addStep(String description, boolean successful) {
        testStepList.add(new TestStep(description, successful));
        return this;
    }

    public void finish() {
        long finishTime = System.nanoTime();
        closeBrowser();
        browser.close();
        testFlow.setFlowName(callingClassName + "." + callingMethodName);
        testFlow.setSteps(testStepList);

//        testFlowService.save(testFlow);
        
        var msg = String.format("Time taken for %s.%s: %ss", callingClassName, callingMethodName, ((finishTime - startTime) / 1_000_000_000.0));
        logger.info(msg);
    }

    public PageManager getPageManager() {
        var stackTrace = new Throwable().getStackTrace();
        callingClassName = stackTrace[1].getClassName();
        callingMethodName = stackTrace[1].getMethodName();

        return pageManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    private void closeBrowser() {
        browser.close();
    }

    public APIManager getApiManager() {
        return apiManager;
    }
}
