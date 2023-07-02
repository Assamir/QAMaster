package org.qam.dto;

import java.util.List;

public class PlanetsDTO {
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String orbital_period;
    private String population;
    private List<String> residents;
    private String rotation_period;
    private String surface_water;
    private String terrain;
    private String url;

    public String getClimate() {
        return climate;
    }

    public PlanetsDTO setClimate(String climate) {
        this.climate = climate;
        return this;
    }

    public String getDiameter() {
        return diameter;
    }

    public PlanetsDTO setDiameter(String diameter) {
        this.diameter = diameter;
        return this;
    }

    public String getGravity() {
        return gravity;
    }

    public PlanetsDTO setGravity(String gravity) {
        this.gravity = gravity;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlanetsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public PlanetsDTO setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
        return this;
    }

    public String getPopulation() {
        return population;
    }

    public PlanetsDTO setPopulation(String population) {
        this.population = population;
        return this;
    }

    public List<String> getResidents() {
        return residents;
    }

    public PlanetsDTO setResidents(List<String> residents) {
        this.residents = residents;
        return this;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public PlanetsDTO setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
        return this;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public PlanetsDTO setSurface_water(String surface_water) {
        this.surface_water = surface_water;
        return this;
    }

    public String getTerrain() {
        return terrain;
    }

    public PlanetsDTO setTerrain(String terrain) {
        this.terrain = terrain;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PlanetsDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "PlanetsDTO{" +
                "climate='" + climate + '\'' +
                ", diameter='" + diameter + '\'' +
                ", gravity='" + gravity + '\'' +
                ", name='" + name + '\'' +
                ", orbital_period='" + orbital_period + '\'' +
                ", population='" + population + '\'' +
                ", residents=" + residents +
                ", rotation_period='" + rotation_period + '\'' +
                ", surface_water='" + surface_water + '\'' +
                ", terrain='" + terrain + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
