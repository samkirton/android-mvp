package com.memtrip.defacto.seventeen.repository.weather;

import com.memtrip.defacto.seventeen.repository.api.ForecastApi;
import com.memtrip.defacto.seventeen.repository.api.model.OpenWeatherForecast;
import com.memtrip.defacto.seventeen.system.ConvertTo;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class WeatherRepository {

    private final ForecastApi weatherApi;
    private final ConvertTo<OpenWeatherForecast, List<Forecast>> convertTo;
    private final String apiKey;
    private final String apiLocation;
    private final String apiUnit;

    public WeatherRepository(String apiKey,
                             String apiLocation,
                             String apiUnit,
                             ForecastApi weatherApi,
                             ConvertTo<OpenWeatherForecast, List<Forecast>> convertTo) {

        this.apiKey = apiKey;
        this.apiLocation = apiLocation;
        this.apiUnit = apiUnit;
        this.weatherApi = weatherApi;
        this.convertTo = convertTo;
    }

    public Single<List<Forecast>> getForecast() {
        return weatherApi.getForecast(apiKey, apiLocation, apiUnit).flatMap(new Function<OpenWeatherForecast, SingleSource<List<Forecast>>>() {
            @Override
            public Single<List<Forecast>> apply(@NonNull final OpenWeatherForecast openWeatherForecast) {
                return new Single<List<Forecast>>() {
                    @Override
                    protected void subscribeActual(@NonNull SingleObserver<? super List<Forecast>> observer) {
                        observer.onSuccess(convertTo.from(openWeatherForecast));
                    }
                };
            }
        });
    }
}