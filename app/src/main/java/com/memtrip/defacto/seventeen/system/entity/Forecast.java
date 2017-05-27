package com.memtrip.defacto.seventeen.system.entity;

import java.util.List;

public class Forecast {

    private final List<Weather> weather;

    public List<Weather> weather() {
        return weather;
    }

    public Weather currentHour() {
        return weather.get(0);
    }

    public Forecast(List<Weather> weather) {
        this.weather = weather;
    }
}
