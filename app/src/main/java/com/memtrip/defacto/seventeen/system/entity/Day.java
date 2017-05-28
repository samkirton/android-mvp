package com.memtrip.defacto.seventeen.system.entity;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

public class Day {

    private final LocalDateTime dateTime;
    private final String dateString;

    public LocalDateTime dateTime() {
        return dateTime;
    }

    public String dateString() {
        return dateString;
    }

    public Day(final long timestamp) {
        dateTime = Instant.ofEpochMilli(timestamp * 1000)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        dateString = dateTime.getDayOfMonth() + " / " + dateTime().getMonthValue();
    }
}