package com.memtrip.defacto.seventeen.system.entity;

import java.util.List;

public class Forecast {

    private final List<Weather> weather;
    private final Weather current;
    private final Temperature high;
    private final Temperature low;

    public List<Weather> weather() {
        return weather;
    }

    public Weather current() {
        return current;
    }

    public Temperature high() {
        return high;
    }

    public Temperature low() {
        return low;
    }

    public Forecast(List<Weather> weather, Weather current, Temperature high, Temperature low) {
        this.weather = weather;
        this.current = current;
        this.high = high;
        this.low = low;
    }
}