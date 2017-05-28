package com.memtrip.defacto.seventeen.repository;

import com.memtrip.defacto.seventeen.repository.api.ForecastApi;
import com.memtrip.defacto.seventeen.repository.api.converter.ConvertToWeather;
import com.memtrip.defacto.seventeen.repository.api.converter.CovertToForecast;
import com.memtrip.defacto.seventeen.repository.api.model.OpenWeather;
import com.memtrip.defacto.seventeen.repository.api.model.OpenWeatherForecast;
import com.memtrip.defacto.seventeen.repository.weather.WeatherRepository;
import com.memtrip.defacto.seventeen.system.ConvertTo;
import com.memtrip.defacto.seventeen.system.entity.Forecast;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public ConvertTo<OpenWeather, Weather> convertToWeather() {
        return new ConvertToWeather();
    }

    @Provides
    public ConvertTo<OpenWeatherForecast, List<Forecast>> convertToForecastList(ConvertTo<OpenWeather, Weather> convertToWeather) {
        return new CovertToForecast(convertToWeather);
    }

    @Provides
    public WeatherRepository weatherRepository(@Named("apiKey") String apiKey,
                                               @Named("apiLocation") String apiLocation,
                                               ForecastApi weatherApi,
                                               ConvertTo<OpenWeatherForecast, List<Forecast>> convertToForecastList) {

        return new WeatherRepository(apiKey, apiLocation, weatherApi, convertToForecastList);
    }
}