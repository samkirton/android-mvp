package com.memtrip.defacto.seventeen.repository;

import com.memtrip.defacto.seventeen.repository.api.OpenWeather;
import com.memtrip.defacto.seventeen.repository.api.OpenWeatherRoot;
import com.memtrip.defacto.seventeen.repository.api.WeatherApi;
import com.memtrip.defacto.seventeen.repository.api.WeatherConverter;
import com.memtrip.defacto.seventeen.repository.weather.WeatherRepository;
import com.memtrip.defacto.seventeen.system.Converter;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoryModule {

    @Provides
    public WeatherApi weatherApi(Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }


    @Provides
    public Converter<OpenWeatherRoot, List<Weather>> weatherConverter() {
        return new WeatherConverter();
    }

    @Provides
    public WeatherRepository weatherRepository(@Named("apiKey") String apiKey,
                                               @Named("apiLocation") String apiLocation,
                                               WeatherApi weatherApi,
                                               Converter<OpenWeatherRoot, List<Weather>> converter) {

        return new WeatherRepository(apiKey, apiLocation, weatherApi, converter);
    }
}