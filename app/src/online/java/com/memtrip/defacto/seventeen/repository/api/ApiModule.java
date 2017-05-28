package com.memtrip.defacto.seventeen.repository.api;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    public ForecastApi weatherApi(Retrofit retrofit) {
        return retrofit.create(ForecastApi.class);
    }
}
