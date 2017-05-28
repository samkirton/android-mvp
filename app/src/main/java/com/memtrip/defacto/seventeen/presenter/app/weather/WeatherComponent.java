package com.memtrip.defacto.seventeen.presenter.app.weather;

import com.memtrip.defacto.seventeen.presenter.PresenterComponent;
import com.memtrip.defacto.seventeen.repository.RepositoryModule;
import com.memtrip.defacto.seventeen.repository.api.ApiModule;
import com.memtrip.defacto.seventeen.system.SystemModule;

import dagger.Component;

@Component(
        modules = {
                ApiModule.class,
                RepositoryModule.class,
                SystemModule.class
        }
)
public interface WeatherComponent extends PresenterComponent {

    String WEATHER_COMPONENT = "WEATHER_COMPONENT";

    void inject(WeatherPresenter presenter);
}