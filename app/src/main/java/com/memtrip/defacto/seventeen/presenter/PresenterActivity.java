package com.memtrip.defacto.seventeen.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.memtrip.defacto.seventeen.presenter.app.DefaultActivity;

public abstract class PresenterActivity<P extends Presenter, C extends PresenterComponent> extends DefaultActivity
    implements PresenterView {

    private P presenter;

    public P presenter() {
        return presenter;
    }

    @SuppressWarnings("unchecked")
    public C injector(String service) {
        return (C) getContext()
                .getApplicationContext()
                .getSystemService(service);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = createPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.stop();
    }

    @Override
    public void startProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    protected abstract P createPresenter();
}
