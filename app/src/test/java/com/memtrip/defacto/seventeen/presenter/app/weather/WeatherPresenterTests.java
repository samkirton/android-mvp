package com.memtrip.defacto.seventeen.presenter.app.weather;

import com.memtrip.defacto.seventeen.R;
import com.memtrip.defacto.seventeen.presenter.PresenterTests;
import com.memtrip.defacto.seventeen.presenter.app.ui.DefaultClick;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WeatherPresenterTests extends PresenterTests<WeatherPresenter> {

    @Mock
    private WeatherView view;

    @Before
    public void setup() {

        MockWeatherComponent injector = DaggerMockWeatherComponent
                .builder()
                .mockSystemModule(systemMock)
                .mockRepositoryModule(repositoryMock)
                .build();

        presenter = new WeatherPresenter(view);
        injector.inject(presenter);

        init(view);
    }

    @Test
    public void loadForecastWithSuccess() {

        // given
        List<Forecast> forecasts = new ArrayList<>();

        Forecast forecast1 = mock(Forecast.class);
        Forecast forecast2 = mock(Forecast.class);
        Forecast forecast3 = mock(Forecast.class);

        {
            forecasts.addAll(Arrays.asList(forecast1, forecast2, forecast3));

            when(repositoryMock.weatherRepository().getForecast())
                    .thenReturn(Single.just(forecasts));
        }

        // when
        presenter.start();

        // then
        verify(view).startProgress();

        verify(view).showForecast(forecasts);
    }

    @Test
    public void loadForecastWithError() {

        // given
        when(repositoryMock.weatherRepository().getForecast())
                .thenReturn(Single.<List<Forecast>>error(new IOException()));

        when(context.getString(R.string.weather_activity_error_title)).thenReturn("Sorry");
        when(context.getString(R.string.weather_activity_error_body)).thenReturn("Could not fetch weather");

        // when
        presenter.start();

        // then
        verify(view).startProgress();

        verify(view).showError("Sorry", "Could not fetch weather");
    }

    @Test
    public void loadForecastRetry() throws Exception {

        // given
        List<Forecast> forecasts = new ArrayList<>();

        Forecast forecast1 = mock(Forecast.class);
        Forecast forecast2 = mock(Forecast.class);
        Forecast forecast3 = mock(Forecast.class);

        {
            forecasts.addAll(Arrays.asList(forecast1, forecast2, forecast3));

            when(repositoryMock.weatherRepository().getForecast())
                    .thenReturn(Single.<List<Forecast>>error(new IOException()))
                    .thenReturn(Single.just(forecasts));
        }

        when(context.getString(R.string.weather_activity_error_title)).thenReturn("Sorry");
        when(context.getString(R.string.weather_activity_error_body)).thenReturn("Could not fetch weather");

        // when
        presenter.start();

        // then
        verify(view).showError("Sorry", "Could not fetch weather");

        // and when
        presenter.viewClicks().accept(new DefaultClick(R.id.weather_activity_retry_button));

        // and then
        verify(view).showForecast(forecasts);
    }
}