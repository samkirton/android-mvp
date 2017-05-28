package com.memtrip.defacto.seventeen.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.memtrip.defacto.seventeen.presenter.app.ui.Click;
import com.memtrip.defacto.seventeen.presenter.app.ui.DefaultActivity;
import com.memtrip.defacto.seventeen.presenter.app.ui.DefaultClick;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;

public abstract class PresenterActivity<P extends Presenter, C extends PresenterComponent> extends DefaultActivity
    implements PresenterView {

    private P presenter;

    @SuppressWarnings("unchecked")
    public C injector(String service) {
        return (C) context()
                .getApplicationContext()
                .getSystemService(service);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = createPresenter();

        if (presenter == null) {
            throw new IllegalStateException("Derivatives of PresenterActivity must provided a " +
                    "Presenter instance via the createPresenter() abstract method.");
        }
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
    public Context context() {
        return this;
    }

    protected void registerClicks(final View view) {
        RxView.clicks(view)
                .flatMap(new Function<Object, ObservableSource<Click>>() {
                    @Override
                    public ObservableSource<Click> apply(Object o) {
                        return new ObservableSource<Click>() {
                            @Override
                            public void subscribe(Observer<? super Click> observer) {
                                observer.onNext(new DefaultClick(view.getId()));
                            }
                        };
                    }
                }).subscribe(presenter.viewClicks());
    }

    protected abstract P createPresenter();
}
