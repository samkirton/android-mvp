package com.memtrip.defacto.seventeen.repository.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("/data/2.5/forecast/")
    Single<OpenWeatherRoot> getWeather(@Query("appid") String apiKey, @Query("q") String q);
}