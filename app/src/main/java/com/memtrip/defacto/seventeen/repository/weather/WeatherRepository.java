package com.memtrip.defacto.seventeen.repository.weather;

import com.memtrip.defacto.seventeen.repository.api.OpenWeather;
import com.memtrip.defacto.seventeen.repository.api.OpenWeatherRoot;
import com.memtrip.defacto.seventeen.repository.api.WeatherApi;
import com.memtrip.defacto.seventeen.system.Converter;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class WeatherRepository {

    private final WeatherApi weatherApi;
    private final Converter<OpenWeatherRoot, List<Weather>> converter;
    private final String apiKey;
    private final String apiLocation;

    public WeatherRepository(String apiKey,
                             String apiLocation,
                             WeatherApi weatherApi,
                             Converter<OpenWeatherRoot, List<Weather>> converter) {

        this.apiKey = apiKey;
        this.apiLocation = apiLocation;
        this.weatherApi = weatherApi;
        this.converter = converter;
    }

    public Single<List<Weather>> getWeather() {
        return weatherApi.getWeather(apiKey, apiLocation).flatMap(new Function<OpenWeatherRoot, SingleSource<List<Weather>>>() {
            @Override
            public Single<List<Weather>> apply(@NonNull final OpenWeatherRoot openWeatherRoot) {
                return new Single<List<Weather>>() {
                    @Override
                    protected void subscribeActual(@NonNull SingleObserver<? super List<Weather>> observer) {
                        observer.onSuccess(converter.intoPresenter(openWeatherRoot));
                    }
                };
            }
        });
    }
}