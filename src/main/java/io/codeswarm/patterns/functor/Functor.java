package io.codeswarm.patterns.functor;

import io.codeswarm.patterns.monoid.Monoid;

import java.util.function.Function;

public interface Functor<T> extends Monoid<T> {
    <R> Functor<R> map(Function<T, R> mapper);
    Boolean eq(T other);
}
