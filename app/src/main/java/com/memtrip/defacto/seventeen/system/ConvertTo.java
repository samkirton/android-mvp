package com.memtrip.defacto.seventeen.system;

public interface ConvertTo<R, P> {

    P from(R repository);
}