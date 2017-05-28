package com.memtrip.defacto.seventeen.repository.api.model;

import java.util.List;

public class OpenWeatherForecast {
    private List<OpenWeather> list;

    public List<OpenWeather> getList() {
        return list;
    }

    public void setList(List<OpenWeather> list) {
        this.list = list;
    }
}
