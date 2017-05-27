package com.memtrip.defacto.seventeen.repository.api;

import com.memtrip.defacto.seventeen.system.Converter;
import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Description;
import com.memtrip.defacto.seventeen.system.entity.Temperature;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherConverter implements Converter<OpenWeatherRoot, List<Weather>> {

    @Override
    public List<Weather> intoPresenter(OpenWeatherRoot openWeatherRoot) {

        List<Weather> weatherList = new ArrayList<>();

        for (OpenWeather openWeather : openWeatherRoot.getList()) {
            weatherList.add(getWeather(openWeather));
        }

        return weatherList;
    }

    private Weather getWeather(OpenWeather openWeather) {
        return new Weather(
                new Day(
                        openWeather.getDt()
                ),
                new Description(
                        getMain(openWeather.getWeather()),
                        getDescription(openWeather.getWeather()),
                        getIcon(openWeather.getWeather())
                ),
                new Temperature(
                        openWeather.getMain().getTemp(),
                        openWeather.getMain().getTempMin(),
                        openWeather.getMain().getTempMax()
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