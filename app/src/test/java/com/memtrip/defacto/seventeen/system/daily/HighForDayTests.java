package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Temperature;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HighForDayTests {

    @Test
    public void highTemperatureValueIsPicked() {

        // given
        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(1, 2, 3), null, new Temperature(6)),
                new Weather(new Day(1, 2, 3), null, new Temperature(11)),
                new Weather(new Day(1, 2, 3), null, new Temperature(20))
        );

        HighForDay highForDay = new HighForDay(weatherList);

        // when
        Temperature temperature = highForDay.find();

        // then
        assertEquals(20, temperature.value());
    }
}