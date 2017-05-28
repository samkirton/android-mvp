package com.memtrip.defacto.seventeen.presenter.app.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DefaultActivity extends AppCompatActivity {

    protected void setVisibility(int visibility, View... views) {
        for (View view : views) {
            view.setVisibility(visibility);
        }
    }
}
