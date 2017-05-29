package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WeatherForCurrentHourTests {

    @Test
    public void weatherForCurrentHourWithCurrentHourExactMatch() {

        // given
        final int CURRENT_HOUR = 2;

        final int HOUR_1 = 1;
        final int HOUR_2 = 2;
        final int HOUR_3 = 3;

        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(HOUR_1, 10, 3), null, null),
                new Weather(new Day(HOUR_2, 10, 3), null, null),
                new Weather(new Day(HOUR_3, 10, 3), null, null)
        );

        WeatherForCurrentHour weatherForCurrentHour = new WeatherForCurrentHour(weatherList, CURRENT_HOUR);

        // when
        Weather weather = weatherForCurrentHour.find();

        // then
        assertEquals(CURRENT_HOUR, weather.day().hour());
    }

    @Test
    public void weatherForCurrentHourWithCurrentHourLessThanAvailableHours() {

        // given
        final int CURRENT_HOUR = 2;

        final int HOUR_1 = 5;
        final int HOUR_2 = 6;
        final int HOUR_3 = 7;

        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(HOUR_1, 10, 3), null, null),
                new Weather(new Day(HOUR_2, 10, 3), null, null),
                new Weather(new Day(HOUR_3, 10, 3), null, null)
        );

        WeatherForCurrentHour weatherForCurrentHour = new WeatherForCurrentHour(weatherList, CURRENT_HOUR);

        // when
        Weather weather = weatherForCurrentHour.find();

        // then
        assertEquals(HOUR_1, weather.day().hour());
    }

    @Test
    public void weatherForCurrentHourWithCurrentHourMoreThanAvailableHours() {

        // given
        final int CURRENT_HOUR = 12;

        final int HOUR_1 = 5;
        final int HOUR_2 = 6;
        final int HOUR_3 = 7;

        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(HOUR_1, 10, 3), null, null),
                new Weather(new Day(HOUR_2, 10, 3), null, null),
                new Weather(new Day(HOUR_3, 10, 3), null, null)
        );

        WeatherForCurrentHour weatherForCurrentHour = new WeatherForCurrentHour(weatherList, CURRENT_HOUR);

        // when
        Weather weather = weatherForCurrentHour.find();

        // then
        assertEquals(HOUR_3, weather.day().hour());
    }
}
