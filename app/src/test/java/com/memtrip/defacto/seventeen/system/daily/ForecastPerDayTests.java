package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Forecast;
import com.memtrip.defacto.seventeen.system.entity.Temperature;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ForecastPerDayTests {

    @Test
    public void splitWeatherListInto3DayForecast() {

        // given
        final int CURRENT_HOUR = 1;

        final int DAY_1 = 10;
        final int DAY_2 = 11;
        final int DAY_3 = 12;

        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(1, DAY_1, 3), null, new Temperature(10)),
                new Weather(new Day(2, DAY_1, 3), null, new Temperature(2)),
                new Weather(new Day(3, DAY_1, 3), null, new Temperature(4)),
                new Weather(new Day(1, DAY_2, 3), null, new Temperature(10)),
                new Weather(new Day(2, DAY_2, 3), null, new Temperature(12)),
                new Weather(new Day(3, DAY_2, 3), null, new Temperature(20)),
                new Weather(new Day(1, DAY_3, 3), null, new Temperature(12)),
                new Weather(new Day(2, DAY_3, 3), null, new Temperature(7)),
                new Weather(new Day(3, DAY_3, 3), null, new Temperature(19))
        );

        ForecastPerDay forecastPerDay = new ForecastPerDay(weatherList, CURRENT_HOUR);

        // when
        List<Forecast> forecasts  = forecastPerDay.find();

        // then
        assertEquals(3, forecasts.size());
    }
}
