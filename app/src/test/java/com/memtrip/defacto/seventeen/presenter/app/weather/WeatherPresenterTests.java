package com.memtrip.defacto.seventeen.presenter.app.weather;

import com.memtrip.defacto.seventeen.presenter.PresenterTests;

import org.mockito.Mock;

public class WeatherPresenterTests extends PresenterTests<WeatherPresenter> {

    @Mock
    private WeatherView weatherView;

    private WeatherComponent injector;

    public WeatherPresenterTests() {

        presenter = new WeatherPresenter(weatherView);
    }
}