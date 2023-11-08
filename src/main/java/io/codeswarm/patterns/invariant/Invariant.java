package io.codeswarm.patterns.invariant;

import io.codeswarm.patterns.functor.Functor;

import java.io.Serializable;
import java.util.function.Function;

public interface Invariant<T,R> extends Serializable {
    Invariant<T,R> imap(Function<T, R> mapper, Function<R, T> reversedMapper);
}
