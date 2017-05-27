package com.memtrip.defacto.seventeen.system.entity;

public class Description {
    private final String title;
    private final String body;
    private final String icon;

    public String title() {
        return title;
    }

    public String body() {
        return body;
    }

    public String icon() {
        return icon;
    }

    public Description(String title, String body, String icon) {
        this.title = title;
        this.body = body;
        this.icon = icon;
    }
}