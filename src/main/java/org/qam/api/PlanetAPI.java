package org.qam.api;

import com.microsoft.playwright.APIRequest;

public class PlanetAPI extends AbstractAPI {
    public PlanetAPI(APIRequest apiRequest) {
        super(apiRequest);
    }

    public PlanetAPI(APIRequest apiRequest, String endpoint) {
        super(apiRequest, endpoint);
    }

    public PlanetAPI(APIRequest apiRequest, String baseURL, String endpoint) {
        super(apiRequest, baseURL, endpoint);
    }

    public void getPlanets() {

    }
}
