package io.codeswarm.patterns.monad;

import io.codeswarm.patterns.functor.Functor;

import java.util.function.Function;

public interface Monad<T> extends Functor<T> {

    Monad<T> pure(T value);
    <R> Monad<R> ap(MonadType<Function<T,R>> transformer);
    <R> Monad<R> flatMap(Function<T, Function<T, R>> mapper);
}
