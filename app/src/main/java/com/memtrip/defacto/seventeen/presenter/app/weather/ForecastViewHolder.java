package com.memtrip.defacto.seventeen.presenter.app.weather;

import android.view.View;
import android.widget.TextView;

import com.memtrip.defacto.seventeen.R;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastViewHolder {

    @BindView(R.id.forecast_adapter_item_weather_title)
    TextView weatherDescriptionTitleTextView;

    @BindView(R.id.forecast_adapter_item_weather_body)
    TextView weatherDescriptionBodyTextView;

    @BindView(R.id.forecast_adapter_item_temp)
    TextView tempTextView;

    @BindView(R.id.forecast_adapter_item_temp_min)
    TextView minTempTextView;

    @BindView(R.id.forecast_adapter_item_temp_max)
    TextView maxTempTextView;

    private final View itemView;

    View view() {
        return itemView;
    }

    ForecastViewHolder(View itemView) {
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    void populate(Forecast forecast) {
        weatherDescriptionTitleTextView.setText(forecast.current().description().title());
        weatherDescriptionBodyTextView.setText(forecast.current().description().body());
        tempTextView.setText(String.valueOf(forecast.current().temperature().current()));
        minTempTextView.setText(String.valueOf(forecast.current().temperature().min()));
        maxTempTextView.setText(String.valueOf(forecast.current().temperature().max()));
    }
}