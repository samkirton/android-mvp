package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Temperature;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

class HighForDay {

    private final List<Weather> weatherList;

    HighForDay(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public Temperature find() {

        int high = 0;

        for (Weather weather : weatherList) {
            if (weather.temperature().value() > high) {
                high = weather.temperature().value();
            }
        }

        return new Temperature(high);
    }
}
