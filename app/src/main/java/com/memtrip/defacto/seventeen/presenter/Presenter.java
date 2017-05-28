package com.memtrip.defacto.seventeen.presenter;

import com.memtrip.defacto.seventeen.presenter.app.ui.Click;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

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

    protected Consumer<Click> viewClicks() {
        return new Consumer<Click>() {
            @Override
            public void accept(@NonNull Click click) throws Exception {
                throw new IllegalStateException("Presenter must override viewClicks() to listen for clicks.");
            }
        };
    }
}
