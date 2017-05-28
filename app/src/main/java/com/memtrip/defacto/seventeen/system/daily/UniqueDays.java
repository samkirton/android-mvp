package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class UniqueDays {

    private final List<Weather> weatherList;

    UniqueDays(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    Set<Integer> find() {

        Set<Integer> uniqueDays = new LinkedHashSet<>();

        for (Weather weather : weatherList) {
            uniqueDays.add(weather.day().dateTime().getDayOfMonth());
        }

        return uniqueDays;
    }
}