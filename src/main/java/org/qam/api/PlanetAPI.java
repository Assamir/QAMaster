package org.qam.api;

import com.google.gson.Gson;
import com.microsoft.playwright.APIRequest;
import org.qam.dto.PlanetsDTO;

import java.util.List;
import java.util.logging.Logger;

public class PlanetAPI extends AbstractSWAPI {
    private static final Logger logger = Logger.getLogger(PlanetAPI.class.getName());

    public PlanetAPI(APIRequest apiRequest) {
        super(apiRequest, "planets");
    }

    public List<PlanetsDTO> getPlanets() {
        return new Gson().fromJson(getWithDefaultConfiguration().get(endpoint).text(), ResultsPlanets.class).getResults();
    }
}
