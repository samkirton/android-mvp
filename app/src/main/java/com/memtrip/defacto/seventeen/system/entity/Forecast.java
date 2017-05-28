package com.memtrip.defacto.seventeen.system.entity;

import java.util.List;

public class Forecast {

    private final List<Weather> weather;
    private final Weather current;

    public List<Weather> weather() {
        return weather;
    }

    public Weather current() {
        return current;
    }

    public Forecast(List<Weather> weather, Weather current) {
        this.weather = weather;
        this.current = current;
    }
}