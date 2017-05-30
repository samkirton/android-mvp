package com.memtrip.defacto.seventeen.repository.api;

import com.memtrip.defacto.seventeen.repository.api.model.OpenWeatherForecast;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastApi {

    String ICON_URL = "http://openweathermap.org/img/w/";

    @GET("/data/2.5/forecast/")
    Single<OpenWeatherForecast> getForecast(@Query("appid") String apiKey,
                                            @Query("q") String q,
                                            @Query("units") String units);
}