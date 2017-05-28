package com.memtrip.defacto.seventeen.presenter.app.weather;

import com.memtrip.defacto.seventeen.presenter.PresenterView;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import java.util.List;

interface WeatherView extends PresenterView {

    void showForecast(List<Forecast> forecasts);

    void showError(String title, String body);
}
