package com.memtrip.defacto.seventeen.system.daily;

import com.memtrip.defacto.seventeen.system.entity.Day;
import com.memtrip.defacto.seventeen.system.entity.Weather;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UniqueDaysTests {

    @Test
    public void uniqueDaysWithNoDuplicates() {

        // given
        final int DAY_1 = 10;
        final int DAY_2 = 11;
        final int DAY_3 = 12;

        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(1, DAY_1, 3), null, null),
                new Weather(new Day(1, DAY_2, 3), null, null),
                new Weather(new Day(1, DAY_3, 3), null, null)
        );

        UniqueDays uniqueDays = new UniqueDays(weatherList);

        // when
        Set<Integer> uniqueDaysSet = uniqueDays.find();

        // then
        assertEquals(3, uniqueDaysSet.size());
    }

    @Test
    public void uniqueDaysFiltersOutAnyDuplicates() {

        // given
        final int DAY_1 = 10;
        final int DAY_2 = 11;
        final int DAY_3 = 12;

        List<Weather> weatherList = Arrays.asList(
                new Weather(new Day(1, DAY_1, 3), null, null),
                new Weather(new Day(1, DAY_2, 3), null, null),
                new Weather(new Day(1, DAY_1, 3), null, null),
                new Weather(new Day(1, DAY_1, 3), null, null),
                new Weather(new Day(1, DAY_3, 3), null, null),
                new Weather(new Day(1, DAY_3, 3), null, null)
        );

        UniqueDays uniqueDays = new UniqueDays(weatherList);

        // when
        Set<Integer> uniqueDaysSet = uniqueDays.find();

        // then
        assertEquals(3, uniqueDaysSet.size());
    }
}
