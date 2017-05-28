package com.memtrip.defacto.seventeen.presenter.app.weather;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.memtrip.defacto.seventeen.R;
import com.memtrip.defacto.seventeen.presenter.PresenterActivity;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.memtrip.defacto.seventeen.presenter.app.weather.WeatherComponent.WEATHER_COMPONENT;

public class WeatherActivity extends PresenterActivity<WeatherPresenter, WeatherComponent> implements WeatherView {

    @BindView(R.id.weather_activity_progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.weather_activity_forecast_view_pager)
    ViewPager viewPager;

    @BindView(R.id.weather_activity_error_root)
    View errorRootView;

    @BindView(R.id.weather_activity_error_title_text)
    TextView errorTitleTextView;

    @BindView(R.id.weather_activity_error_body_text)
    TextView errorBodyTextView;

    @BindView(R.id.weather_activity_retry_button)
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        ButterKnife.bind(this);

        registerClicks(retryButton);
    }

    @Override
    protected WeatherPresenter createPresenter() {
        WeatherPresenter presenter = new WeatherPresenter(this);
        injector(WEATHER_COMPONENT).inject(presenter);
        return presenter;
    }

    @Override
    public void showForecast(List<Forecast> forecasts) {
        setVisibility(View.VISIBLE, viewPager);
    }

    @Override
    public void showError(String title, String body) {
        setVisibility(View.VISIBLE, errorRootView);
        errorTitleTextView.setText(title);
        errorBodyTextView.setText(body);
    }

    @Override
    public void startProgress() {
        setVisibility(View.VISIBLE, progressBar);
        setVisibility(View.GONE, viewPager, errorRootView);
    }

    @Override
    public void hideProgress() {
        setVisibility(View.GONE, progressBar);
    }
}
