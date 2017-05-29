package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Temperature;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LowForDayTests {

    @Test
    public void lowTemperatureValueIsPicked() {

        // given
        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(1, 2, 3), null, new Temperature(6)),
                new Weather(new Day(1, 2, 3), null, new Temperature(11)),
                new Weather(new Day(1, 2, 3), null, new Temperature(20))
        );

        LowForDay lowForDay = new LowForDay(weatherList);

        // when
        Temperature temperature = lowForDay.find();

        // then
        assertEquals(6, temperature.value());
    }
}