package com.memtrip.defacto.seventeen.repository;

import com.memtrip.defacto.seventeen.repository.api.ForecastApi;
import com.memtrip.defacto.seventeen.repository.api.converter.ConvertToWeather;
import com.memtrip.defacto.seventeen.repository.api.converter.CovertToForecast;
import com.memtrip.defacto.seventeen.repository.api.converter.ForecastDateMaker;
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
    ForecastDateMaker forecastDateMaker() {
        return new ForecastDateMaker();
    }

    @Provides
    ConvertTo<OpenWeather, Weather> convertToWeather(ForecastDateMaker forecastDateMaker) {
        return new ConvertToWeather(forecastDateMaker);
    }

    @Provides
    ConvertTo<OpenWeatherForecast, List<Forecast>> convertToForecastList(
            ConvertTo<OpenWeather, Weather> convertToWeather, ForecastDateMaker forecastDateMaker) {

        return new CovertToForecast(convertToWeather, forecastDateMaker);
    }

    @Provides
    WeatherRepository weatherRepository(@Named("apiKey") String apiKey,
                                        @Named("apiLocation") String apiLocation,
                                        @Named("apiUnit") String apiUnit,
                                        ForecastApi weatherApi,
                                        ConvertTo<OpenWeatherForecast, List<Forecast>> convertToForecastList) {

        return new WeatherRepository(apiKey, apiLocation, apiUnit, weatherApi, convertToForecastList);
    }
}