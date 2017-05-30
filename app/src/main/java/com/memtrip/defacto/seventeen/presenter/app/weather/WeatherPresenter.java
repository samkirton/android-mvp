package com.memtrip.defacto.seventeen.presenter.app.weather;

import com.memtrip.defacto.seventeen.R;
import com.memtrip.defacto.seventeen.presenter.Presenter;
import com.memtrip.defacto.seventeen.presenter.app.ui.Click;
import com.memtrip.defacto.seventeen.repository.weather.WeatherRepository;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

class WeatherPresenter extends Presenter<WeatherView> {

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
        loadForecast();
    }

    private void loadForecast() {

        view().startProgress();

        weatherRepository.getForecast()
                .observeOn(mainThreadScheduler)
                .subscribeOn(backgroundThreadScheduler)
                .subscribe(new SingleObserver<List<Forecast>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(@NonNull List<Forecast> forecasts) {
                        forecastSuccess(forecasts);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        forecastError();
                    }
                });
    }

    private void forecastSuccess(List<Forecast> forecasts) {

        view().hideProgress();

        view().showForecast(forecasts);
    }

    private void forecastError() {

        view().hideProgress();

        view().showError(
                view().context().getString(R.string.weather_activity_error_title),
                view().context().getString(R.string.weather_activity_error_body)
        );
    }

    @Override
    protected Consumer<Click> viewClicks() {
        return new Consumer<Click>() {
            @Override
            public void accept(Click click) {
                switch (click.id()) {
                    case R.id.weather_activity_retry_button:
                        loadForecast();
                        break;
                }
            }
        };
    }

    @Override
    protected void stop() {
        disposable.dispose();
    }
}