package com.memtrip.defacto.seventeen.presenter;

public abstract class Presenter<V extends PresenterView> {

    private final V view;

    public V view() {
        return view;
    }

    public Presenter(V view) {
        this.view = view;
    }

    protected abstract void start();

    protected abstract void stop();
}
