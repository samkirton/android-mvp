package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Weather;

import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;

import java.util.List;

class WeatherForCurrentHour {

    private final List<Weather> weatherList;
    private final int currentHour;

    WeatherForCurrentHour(List<Weather> weatherList) {
        this.weatherList = weatherList;
        this.currentHour = Instant.ofEpochMilli(System.currentTimeMillis())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .getHour();
    }

    Weather find() {

        for (Weather weather : weatherList) {
            int weatherHour = weather.day().dateTime().getHour();

            if (currentHour <= weatherHour) {
                return weather;
            }
        }

        return weatherList.get(0);
    }
}