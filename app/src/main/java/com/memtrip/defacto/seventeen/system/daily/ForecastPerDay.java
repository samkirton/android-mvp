package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Forecast;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ForecastPerDay {
    private final WeatherForDay weatherForDay;
    private final UniqueDays uniqueDays;

    public ForecastPerDay(List<Weather> weatherList) {
        this.uniqueDays = new UniqueDays(weatherList);
        this.weatherForDay = new WeatherForDay(weatherList);
    }

    public List<Forecast> find() {

        List<Forecast> forecasts = new ArrayList<>();

        Set<Integer> uniqueDaySet = uniqueDays.find();

        for (int day : uniqueDaySet) {

            List<Weather> weather = weatherForDay.find(day);

            forecasts.add(new Forecast(
                    weather,
                    new WeatherForCurrentHour(weather).find()
            ));
        }

        return forecasts;
    }
}