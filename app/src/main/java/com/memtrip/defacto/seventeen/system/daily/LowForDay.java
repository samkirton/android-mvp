package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Temperature;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

class LowForDay {

    private final List<Weather> weatherList;

    LowForDay(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public Temperature find() {

        final int UNASSIGNED = -9999;

        int low = UNASSIGNED;

        for (Weather weather : weatherList) {
            if (low == UNASSIGNED || weather.temperature().value() < low) {
                low = weather.temperature().value();
            }
        }

        return new Temperature(low);
    }
}
