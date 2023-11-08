package io.codeswarm.patterns.applicative;

import io.codeswarm.patterns.functor.Functor;

import java.util.function.Function;

public interface Applicative<T> extends Functor<T> {
    Applicative<T> pure(T value);
    <R> Applicative<R> ap(ApplicativeType<Function<T,R>> transformer);
}
