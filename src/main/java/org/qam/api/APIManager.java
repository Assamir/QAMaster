package org.qam.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import org.qam.conf.TestContext;

import java.util.HashMap;
import java.util.Map;

public class APIManager {

    private static final String API_TOKEN = "MY_API_TOKEN";
    protected static Map<String, AbstractAPI> pageMap = new HashMap<>();
    protected TestContext testContext;
    protected APIRequest apiRequest;

    public APIManager(TestContext testContext) {
        this.testContext = testContext;
        apiRequest = testContext.getScenarioContext().getPlaywright().request();
    }

    private APIRequestContext getWithDefaultConfiguration() {
        Map<String, String> headers = new HashMap<>();
        // We set this header per GitHub guidelines.
        headers.put("Accept", "application/vnd.github.v3+json");
        // Add authorization token to all requests.
        // Assuming personal access token available in the environment.
        headers.put("Authorization", "token " + API_TOKEN);
        return apiRequest.newContext(new APIRequest.NewContextOptions()
                // All requests we send go to this API endpoint.
                .setBaseURL("https://swapi.dev/api/")
                .setExtraHTTPHeaders(headers));
    }

}
