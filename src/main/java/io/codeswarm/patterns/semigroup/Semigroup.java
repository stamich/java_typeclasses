package io.codeswarm.patterns.semigroup;

@FunctionalInterface
public interface Semigroup<T> {

    T combine(T a, T b);
}
