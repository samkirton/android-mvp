package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.ArrayList;
import java.util.List;

class WeatherForDay {

    private final List<Weather> weatherList;

    WeatherForDay(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    List<Weather> find(int dayOfMonth) {

        List<Weather> weatherForDay = new ArrayList<>();

        for (Weather weather : weatherList) {
            if (dayOfMonth == weather.day().dayOfMonth()) {
                weatherForDay.add(weather);
            }
        }

        return weatherForDay;
    }
}