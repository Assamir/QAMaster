package org.qam.api;

import com.microsoft.playwright.APIRequest;
import org.apache.commons.lang3.StringUtils;

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
