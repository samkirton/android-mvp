package com.memtrip.defacto.seventeen.system.entity;

public class Weather {
    private final Day day;
    private final Description description;
    private final Temperature temperature;

    public Day day() {
        return day;
    }

    public Description description() {
        return description;
    }

    public Temperature temperature() {
        return temperature;
    }

    public Weather(Day day, Description description, Temperature temperature) {
        this.day = day;
        this.description = description;
        this.temperature = temperature;
    }
}