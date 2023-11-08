package io.codeswarm.patterns.apply;

import io.codeswarm.patterns.functor.Functor;

import java.util.function.Function;

public interface Apply<T> extends Functor<T> {
    <R> Apply<R> ap(ApplyType<Function<T,R>> transformer);

}
