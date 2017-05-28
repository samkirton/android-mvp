package com.memtrip.defacto.seventeen.system.entity;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

public class Day {

    private final LocalDateTime dateTime;

    public LocalDateTime dateTime() {
        return dateTime;
    }

    public Day(final long timestamp) {
        dateTime = Instant.ofEpochMilli(timestamp * 1000)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}