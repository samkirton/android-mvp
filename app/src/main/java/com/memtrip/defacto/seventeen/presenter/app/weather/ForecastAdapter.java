package com.memtrip.defacto.seventeen.presenter.app.weather;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.memtrip.defacto.seventeen.R;
import com.memtrip.defacto.seventeen.system.entity.Forecast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastAdapter extends PagerAdapter {

    private final List<Forecast> forecasts;
    private final LayoutInflater inflater;

    public ForecastAdapter(List<Forecast> forecasts, Context context) {
        this.forecasts = forecasts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ForecastViewHolder forecastViewHolder = new ForecastViewHolder(
                inflater.inflate(R.layout.forecast_adapter_item, null)
        );

        forecastViewHolder.populate(forecasts.get(position));

        container.addView(forecastViewHolder.view());

        return forecastViewHolder.view();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return forecasts.get(position).current().day().dateString();
    }

    @Override
    public int getCount() {
        return forecasts != null ? forecasts.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
