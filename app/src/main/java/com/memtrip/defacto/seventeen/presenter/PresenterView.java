package com.memtrip.defacto.seventeen.presenter;

import android.content.Context;

public interface PresenterView {

    Context getContext();

    void startProgress();

    void hideProgress();
}
