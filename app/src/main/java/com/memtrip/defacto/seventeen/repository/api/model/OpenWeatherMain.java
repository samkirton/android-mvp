package com.memtrip.defacto.seventeen.repository.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherMain {
    private float temp;
    private float tempMin;
    private float tempMax;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @JsonProperty("temp_min")
    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }
}
