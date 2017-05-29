package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

class WeatherForCurrentHour {

    private final List<Weather> weatherList;
    private final int currentHour;

    WeatherForCurrentHour(List<Weather> weatherList, int currentHour) {
        this.weatherList = weatherList;
        this.currentHour = currentHour;
    }

    Weather find() {

        for (Weather weather : weatherList) {
            int weatherHour = weather.day().hour();

            if (currentHour <= weatherHour) {
                return weather;
            }
        }

        return weatherList.get(weatherList.size() - 1);
    }
}