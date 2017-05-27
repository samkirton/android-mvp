package com.memtrip.defacto.seventeen.system.entity;

public class Temperature {
    private final float current;
    private final float min;
    private final float max;

    public float current() {
        return current;
    }

    public float min() {
        return min;
    }

    public float max() {
        return max;
    }

    public Temperature(float current, float min, float max) {
        this.current = current;
        this.min = min;
        this.max = max;
    }
}
