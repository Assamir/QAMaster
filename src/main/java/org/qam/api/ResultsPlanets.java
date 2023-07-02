package org.qam.api;

import org.qam.dto.PlanetsDTO;

import java.util.ArrayList;
import java.util.List;

public class ResultsPlanets extends ResultsSWAPIWrapper {
    private List<PlanetsDTO> results = null;

    public List<PlanetsDTO> getResults() {
        return results;
    }

    public ResultsPlanets setResults(List<PlanetsDTO> results) {
        this.results = results;
        return this;
    }
}
