package com.memtrip.defacto.seventeen.repository.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.memtrip.defacto.seventeen.BuildConfig;
import com.memtrip.defacto.seventeen.repository.api.model.OpenWeatherForecast;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import retrofit2.http.Query;

class DummyForecastApi implements ForecastApi {

    private final ObjectMapper objectMapper;

    DummyForecastApi(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Single<OpenWeatherForecast> getForecast(@Query("appid") String apiKey, @Query("q") String q) {
        return new Single<OpenWeatherForecast>() {
            @Override
            protected void subscribeActual(@NonNull SingleObserver<? super OpenWeatherForecast> observer) {
                try {
                    observer.onSuccess(objectMapper.readValue(fromFile("weather.json"), OpenWeatherForecast.class));
                } catch (IOException e) {
                    observer.onError(e);
                }
            }
        }.delay(BuildConfig.OFFLINE_REQUESTS_DELAY, TimeUnit.SECONDS);
    }

    private String fromFile(String fileName) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
        return IOUtils.toString(in, Charset.forName("utf-8"));
    }
}