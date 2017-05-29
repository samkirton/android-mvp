package com.memtrip.defacto.seventeen.system.entity;

public class Day {

    private final int hour;
    private final int dayOfMonth;
    private final String dateString;

    public int hour() {
        return hour;
    }

    public int dayOfMonth() {
       return dayOfMonth;
    }

    public String dateString() {
        return dateString;
    }

    public Day(final int hour, final int dayOfMonth, final int month) {
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;

        dateString = dayOfMonth + " / " + month;
    }
}