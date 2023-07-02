package org.qam.api;

import com.microsoft.playwright.APIRequest;
import org.qam.conf.TestContext;

import java.util.HashMap;
import java.util.Map;

public class APIManager {

    public static final String API_TOKEN = "MY_API_TOKEN";
    protected static Map<String, AbstractAPI> pageMap = new HashMap<>();
    protected TestContext testContext;
    protected APIRequest apiRequest;

    public APIManager(TestContext testContext) {
        this.testContext = testContext;
        apiRequest = testContext.getScenarioContext().getPlaywright().request();
    }

    public PlanetAPI Planets(){
        return new PlanetAPI(apiRequest);
    }

}
