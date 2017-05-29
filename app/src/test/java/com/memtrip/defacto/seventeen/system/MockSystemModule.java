package com.memtrip.defacto.seventeen.system;

import android.content.Context;

import org.mockito.Mock;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

@Module
public class MockSystemModule {

    @Mock
    Context context;

    @Provides
    public Context context() {
        return context;
    }

    @Provides
    @Named("mainThreadScheduler")
    public Scheduler mainThreadScheduler() {
        return Schedulers.trampoline();
    }

    @Provides
    @Named("backgroundThreadScheduler")
    public Scheduler backgroundThreadScheduler() {
        return Schedulers.trampoline();
    }
}