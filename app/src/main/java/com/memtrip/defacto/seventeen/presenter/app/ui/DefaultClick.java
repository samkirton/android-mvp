package com.memtrip.defacto.seventeen.presenter.app.ui;

public class DefaultClick implements Click {

    private final int id;

    public DefaultClick(int id) {
        this.id = id;
    }

    @Override
    public int id() {
        return id;
    }
}
