package com.memtrip.defacto.seventeen.repository.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    public ForecastApi weatherApi(ObjectMapper objectMapper) {
        return new DummyForecastApi(objectMapper);
    }
}