package com.memtrip.defacto.seventeen.presenter;

import android.content.Context;

public interface PresenterView {

    Context context();

    void startProgress();

    void hideProgress();
}
