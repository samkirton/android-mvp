package com.memtrip.defacto.seventeen.presenter.app.weather;

import com.memtrip.defacto.seventeen.presenter.Presenter;
import com.memtrip.defacto.seventeen.repository.weather.WeatherRepository;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class WeatherPresenter extends Presenter<WeatherView> {

    @Inject
    @Named("mainThreadScheduler")
    Scheduler mainThreadScheduler;

    @Inject
    @Named("backgroundThreadScheduler")
    Scheduler backgroundThreadScheduler;

    @Inject
    WeatherRepository weatherRepository;

    private Disposable disposable;

    WeatherPresenter(WeatherView view) {
        super(view);
    }

    @Override
    protected void start() {
        weatherRepository.getWeather()
                .observeOn(mainThreadScheduler)
                .subscribeOn(backgroundThreadScheduler)
                .subscribe(new SingleObserver<List<Weather>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(@NonNull List<Weather> weather) {
                        getWeatherSuccess(weather);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getWeatherError();
                    }
                });
    }

    private void getWeatherSuccess(List<Weather> weather) {
        System.currentTimeMillis();
    }

    private void getWeatherError() {

    }

    @Override
    protected void stop() {
        disposable.dispose();
    }
}