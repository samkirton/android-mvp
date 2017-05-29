package com.memtrip.defacto.seventeen.repository.api.converter;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

public class ForecastDateMaker {

    ForecastDate forcastDate(long timestamp) {
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return new ForecastDate(
                localDateTime.getHour(),
                localDateTime.getDayOfMonth(),
                localDateTime.getMonthValue()
        );
    }
}