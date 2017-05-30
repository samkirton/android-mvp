package com.memtrip.defacto.seventeen.system;

import android.content.Context;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.memtrip.defacto.seventeen.R;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class SystemModule {

    protected final Context context;

    public SystemModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context;
    }

    @Provides
    @Named("mainThreadScheduler")
    Scheduler mainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Named("backgroundThreadScheduler")
    Scheduler backgroundThreadScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Named("apiEndpoint")
    String apiEndpoint() {
        return context.getString(R.string.app_api_endpoint);
    }

    @Provides
    @Named("apiKey")
    String apiKey() {
        return context.getString(R.string.app_api_key);
    }

    @Provides
    @Named("apiLocation")
    String apiLocation() {
        return context.getString(R.string.app_api_location);
    }

    @Provides
    @Named("apiUnit")
    String apiUnit() {
        return context.getString(R.string.app_api_units);
    }

    @Provides
    OkHttpClient okHttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        int timeout = context.getResources().getInteger(R.integer.app_server_timeout);

        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper;
    }

    @Provides
    retrofit2.Converter.Factory converterFactory(ObjectMapper mapper) {
        return JacksonConverterFactory.create(mapper);
    }

    @Provides
    Retrofit retrofit(@Named("apiEndpoint") String endpoint,
                      OkHttpClient client,
                      retrofit2.Converter.Factory converterFactory) {

        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(client)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}