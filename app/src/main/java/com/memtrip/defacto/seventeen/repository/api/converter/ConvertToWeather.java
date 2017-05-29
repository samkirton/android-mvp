package com.memtrip.defacto.seventeen.repository.api.converter;

import com.memtrip.defacto.seventeen.repository.api.model.OpenWeather;
import com.memtrip.defacto.seventeen.repository.api.model.OpenWeatherWeather;
import com.memtrip.defacto.seventeen.system.ConvertTo;
import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Description;
import com.memtrip.defacto.seventeen.system.entity.Temperature;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

public class ConvertToWeather implements ConvertTo<OpenWeather, Weather> {

    private final ForecastDateMaker forecastDateMaker;

    public ConvertToWeather(ForecastDateMaker forecastDateMaker) {
        this.forecastDateMaker = forecastDateMaker;
    }

    @Override
    public Weather from(OpenWeather openWeather) {

        ForecastDate forecastDate = forecastDateMaker.forcastDate(openWeather.getDt() * 1000);

        return new Weather(
                new Day(
                        forecastDate.currentHour(),
                        forecastDate.dayOfMonth(),
                        forecastDate.month()
                ),
                new Description(
                        getMain(openWeather.getWeather()),
                        getDescription(openWeather.getWeather()),
                        getIcon(openWeather.getWeather())
                ),
                new Temperature(
                        Math.round(openWeather.getMain().getTemp())
                )
        );
    }

    private String getMain(List<OpenWeatherWeather> weatherList) {
        return weatherList != null && weatherList.size() > 0 ?
                weatherList.get(0).getMain() : null;
    }

    private String getDescription(List<OpenWeatherWeather> weatherList) {
        return weatherList != null && weatherList.size() > 0 ?
                weatherList.get(0).getDescription() : null;
    }

    private String getIcon(List<OpenWeatherWeather> weatherList) {
        return weatherList != null && weatherList.size() > 0 ?
                weatherList.get(0).getIcon() : null;
    }
}