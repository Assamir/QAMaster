package org.qam.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class AbstractAPI {
    protected APIRequest apiRequest;
    protected String baseURL = "";
    protected String endpoint = "";

    protected AbstractAPI(APIRequest apiRequest) {
        setApiRequest(apiRequest);
    }

    protected AbstractAPI(APIRequest apiRequest, String endpoint) {
        setApiRequest(apiRequest);
        setEndpoint(endpoint);
    }

    protected AbstractAPI(APIRequest apiRequest, String baseURL, String endpoint) {
        setApiRequest(apiRequest);
        setEndpoint(endpoint);
        setBaseURL(baseURL);
    }

    protected APIRequestContext getWithDefaultConfiguration() {
        Map<String, String> headers = new HashMap<>();
        // We set this header per GitHub guidelines.
//        headers.put("Accept", "application/vnd.github.v3+json");
        headers.put("Content-Type", "application/json");

        // Add authorization token to all requests.
        // Assuming personal access token available in the environment.
//        headers.put("Authorization", "token " + APIManager.API_TOKEN);
        return apiRequest.newContext(new APIRequest.NewContextOptions()
                // All requests we send go to this API endpoint.
                .setBaseURL("https://swapi.dev/api/")
                .setExtraHTTPHeaders(headers));
    }
    protected APIRequest.NewContextOptions getWithDefaultConfigurationOptions() {
        Map<String, String> headers = new HashMap<>();
        // We set this header per GitHub guidelines.
        headers.put("Accept", "application/vnd.github.v3+json");
        // Add authorization token to all requests.
        // Assuming personal access token available in the environment.
        headers.put("Authorization", "token " + APIManager.API_TOKEN);
        return new APIRequest.NewContextOptions();
//        return apiRequest.newContext(new APIRequest.NewContextOptions()
//                // All requests we send go to this API endpoint.
//                .setBaseURL("https://swapi.dev/api/")
//                .setExtraHTTPHeaders(headers));
    }

    private void setApiRequest(APIRequest apiRequest) {
        if(apiRequest == null) throw new RuntimeException("APIRequest can't be NULL");
        this.apiRequest = apiRequest;
    }

    private void setBaseURL(String baseURL) {
        if(StringUtils.isNotBlank(baseURL)) this.baseURL = baseURL.trim();
    }

    private void setEndpoint(String endpoint) {
        if(StringUtils.isNotBlank(endpoint)) this.endpoint = endpoint.trim();
    }
}
