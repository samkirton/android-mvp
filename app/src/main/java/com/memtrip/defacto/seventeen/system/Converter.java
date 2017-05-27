package com.memtrip.defacto.seventeen.system;

public interface Converter<R, P> {

    P intoPresenter(R repository);
}