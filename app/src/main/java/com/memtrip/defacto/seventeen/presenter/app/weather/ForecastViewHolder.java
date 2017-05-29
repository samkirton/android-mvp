package com.memtrip.defacto.seventeen.presenter.app.weather;

import android.view.View;
import android.widget.TextView;

import com.memtrip.defacto.seventeen.R;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

class ForecastViewHolder {

    @BindView(R.id.forecast_adapter_item_weather_title)
    TextView weatherDescriptionTitleTextView;

    @BindView(R.id.forecast_adapter_item_weather_body)
    TextView weatherDescriptionBodyTextView;

    @BindView(R.id.forecast_adapter_item_temp)
    TextView tempTextView;

    @BindView(R.id.forecast_adapter_item_temp_min)
    TextView lowTempTextView;

    @BindView(R.id.forecast_adapter_item_temp_max)
    TextView highTempTextView;

    @BindString(R.string.forecast_adapter_item_celsius)
    String celsius;

    private final View itemView;

    View view() {
        return itemView;
    }

    ForecastViewHolder(View itemView) {
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    void populate(Forecast forecast) {

        String temp = String.valueOf(forecast.current().temperature().value()) + celsius;
        String low = String.valueOf(forecast.low().value()) + celsius;
        String high = String.valueOf(forecast.high().value()) + celsius;

        weatherDescriptionTitleTextView.setText(forecast.current().description().title());
        weatherDescriptionBodyTextView.setText(forecast.current().description().body());
        tempTextView.setText(temp);
        lowTempTextView.setText(low);
        highTempTextView.setText(high);
    }
}