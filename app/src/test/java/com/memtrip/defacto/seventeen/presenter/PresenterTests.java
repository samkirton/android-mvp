package com.memtrip.defacto.seventeen.presenter;

import android.content.Context;

import com.memtrip.defacto.seventeen.repository.MockRepositoryModule;
import com.memtrip.defacto.seventeen.system.MockSystemModule;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PresenterTests<P extends Presenter> {

    @Mock
    Context context;

    protected MockSystemModule mockSystemModule;

    protected MockRepositoryModule mockRepositoryModule;

    protected P presenter;

    protected PresenterTests() {

        MockitoAnnotations.initMocks(this);

        mockSystemModule = new MockSystemModule();
        MockitoAnnotations.initMocks(mockSystemModule);

        mockRepositoryModule = new MockRepositoryModule();
        MockitoAnnotations.initMocks(mockRepositoryModule);
    }
}
