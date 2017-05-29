package com.memtrip.defacto.seventeen.repository.api.converter;

class ForecastDate {

    private final int currentHour;
    private final int dayOfMonth;
    private final int month;

    int currentHour() {
        return currentHour;
    }

    int dayOfMonth() {
        return dayOfMonth;
    }

    int month() {
        return month;
    }

    ForecastDate(int currentHour, int dayOfMonth, int month) {
        this.currentHour = currentHour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
    }
}