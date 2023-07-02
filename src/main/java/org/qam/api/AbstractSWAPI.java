package org.qam.api;

import com.microsoft.playwright.APIRequest;

public abstract class AbstractSWAPI extends AbstractAPI {
    private static final String BASE_URI = "https://swapi.dev/api";

    private AbstractSWAPI(APIRequest apiRequest) {
        super(apiRequest);
    }


    private AbstractSWAPI(APIRequest apiRequest, String baseURL, String endpoint) {
        super(apiRequest, baseURL, endpoint);
    }

    protected AbstractSWAPI(APIRequest apiRequest, String endpoint) {
        super(apiRequest, BASE_URI, endpoint);
    }

    @Override
    public String toString() {
        return "AbstractSWAPI{" +
                "apiRequest=" + apiRequest +
                ", baseURL='" + baseURL + '\'' +
                ", endpoint='" + endpoint + '\'' +
                '}';
    }
}
