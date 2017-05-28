package com.memtrip.defacto.seventeen.system.entity;

public class Temperature {
    private final int current;
    private final int min;
    private final int max;

    public int current() {
        return current;
    }

    public int min() {
        return min;
    }

    public int max() {
        return max;
    }

    public Temperature(int current, int min, int max) {
        this.current = current;
        this.min = min;
        this.max = max;
    }
}