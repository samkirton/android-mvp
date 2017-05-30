package com.memtrip.defacto.seventeen.presenter.app.weather;

import com.memtrip.defacto.seventeen.presenter.PresenterComponent;
import com.memtrip.defacto.seventeen.repository.MockRepositoryModule;
import com.memtrip.defacto.seventeen.system.MockSystemModule;

import dagger.Component;

@Component(
        modules = {
                MockSystemModule.class,
                MockRepositoryModule.class
        }
)
interface MockWeatherComponent extends PresenterComponent {

    void inject(WeatherPresenter weatherPresenter);
}