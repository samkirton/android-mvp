package com.memtrip.defacto.seventeen.repository.api.converter;

import com.memtrip.defacto.seventeen.repository.api.model.OpenWeather;
import com.memtrip.defacto.seventeen.repository.api.model.OpenWeatherForecast;
import com.memtrip.defacto.seventeen.system.ConvertTo;
import com.memtrip.defacto.seventeen.system.daily.ForecastPerDay;
import com.memtrip.defacto.seventeen.system.entity.Forecast;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.ArrayList;
import java.util.List;

public class CovertToForecast implements ConvertTo<OpenWeatherForecast, List<Forecast>> {

    private final ConvertTo<OpenWeather, Weather> convertToWeather;
    private final int currentHour;

    public CovertToForecast(ConvertTo<OpenWeather, Weather> convertToWeather, ForecastDateMaker forecastDateMaker) {
        this.convertToWeather = convertToWeather;
        currentHour = forecastDateMaker.forcastDate(System.currentTimeMillis()).currentHour();
    }

    @Override
    public List<Forecast> from(OpenWeatherForecast openWeatherForecast) {

        List<Weather> weatherList = weatherListFromOpenWeatherForecast(openWeatherForecast);

        ForecastPerDay forecastPerDay = new ForecastPerDay(weatherList, currentHour);

        return forecastPerDay.find();
    }

    private List<Weather> weatherListFromOpenWeatherForecast(OpenWeatherForecast openWeatherForecast) {

        List<Weather> weatherList = new ArrayList<>();

        for (OpenWeather openWeather : openWeatherForecast.getList()) {
            weatherList.add(convertToWeather.from(openWeather));
        }

        return weatherList;
    }
}