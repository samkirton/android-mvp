package com.memtrip.defacto.seventeen.presenter;

import android.content.Context;

import com.memtrip.defacto.seventeen.repository.MockRepositoryModule;
import com.memtrip.defacto.seventeen.system.MockSystemModule;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class PresenterTests<P extends Presenter> {

    @Mock
    protected Context context;

    protected MockSystemModule systemMock;

    protected MockRepositoryModule repositoryMock;

    protected P presenter;

    protected PresenterTests() {

        MockitoAnnotations.initMocks(this);

        systemMock = new MockSystemModule(context);
        MockitoAnnotations.initMocks(systemMock);

        repositoryMock = new MockRepositoryModule();
        MockitoAnnotations.initMocks(repositoryMock);
    }

    protected void init(PresenterView view) {
        when(view.context()).thenReturn(context);
    }
}
