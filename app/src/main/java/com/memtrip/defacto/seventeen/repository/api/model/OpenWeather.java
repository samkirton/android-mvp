package com.memtrip.defacto.seventeen.repository.api.model;

import java.util.List;

public class OpenWeather {
    private long dt;
    private OpenWeatherMain main;
    private List<OpenWeatherWeather> weather;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public OpenWeatherMain getMain() {
        return main;
    }

    public void setMain(OpenWeatherMain main) {
        this.main = main;
    }

    public List<OpenWeatherWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<OpenWeatherWeather> weather) {
        this.weather = weather;
    }
}