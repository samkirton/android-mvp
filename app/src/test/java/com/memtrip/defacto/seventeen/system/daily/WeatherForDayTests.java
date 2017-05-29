package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WeatherForDayTests {

    @Test
    public void filterWeatherPerDay() {

        // given
        final int DAY_1 = 10;
        final int DAY_2 = 11;
        final int DAY_3 = 12;

        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(1, DAY_1, 3), null, null),
                new Weather(new Day(2, DAY_1, 3), null, null),
                new Weather(new Day(1, DAY_3, 3), null, null),
                new Weather(new Day(3, DAY_1, 3), null, null),
                new Weather(new Day(4, DAY_1, 3), null, null),
                new Weather(new Day(1, DAY_2, 3), null, null)
        );


        WeatherForDay weatherForDay = new WeatherForDay(weatherList);

        // when
        List<Weather> weatherListForDay = weatherForDay.find(10);

        // then
        assertEquals(4, weatherListForDay.size());
    }
}
