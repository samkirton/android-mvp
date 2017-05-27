package com.memtrip.defacto.seventeen.presenter.app.weather;

import android.os.Bundle;

import com.memtrip.defacto.seventeen.R;
import com.memtrip.defacto.seventeen.presenter.PresenterActivity;

import static com.memtrip.defacto.seventeen.presenter.app.weather.WeatherComponent.WEATHER_COMPONENT;

public class WeatherActivity extends PresenterActivity<WeatherPresenter, WeatherComponent> implements WeatherView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
    }

    @Override
    protected WeatherPresenter createPresenter() {
        WeatherPresenter presenter = new WeatherPresenter(this);
        injector(WEATHER_COMPONENT).inject(presenter);
        return presenter;
    }

    @Override
    public void showWeather() {

    }
}
