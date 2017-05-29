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

import org.mockito.Mock;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class MockRepositoryModule {

    @Mock
    ForecastDateMaker forecastDateMaker;

    @Mock
    ConvertToWeather convertToWeather;

    @Mock
    CovertToForecast covertToForecast;

    @Mock
    WeatherRepository weatherRepository;

    @Provides
    public ForecastDateMaker forecastDateMaker() {
        return forecastDateMaker;
    }

    @Provides
    public ConvertTo<OpenWeather, Weather> convertToWeather() {
        return convertToWeather;
    }

    @Provides
    public ConvertTo<OpenWeatherForecast, List<Forecast>> convertToForecastList() {

        return covertToForecast;
    }

    @Provides
    public WeatherRepository weatherRepository() {

        return weatherRepository;
    }
}
