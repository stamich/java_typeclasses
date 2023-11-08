package io.codeswarm.patterns.functor;

import java.util.Optional;
import java.util.function.Function;

public class FunctorType<T> implements Functor<T> {

    private final T value;

    public FunctorType(T value) {
        this.value = value;
    }

    @Override
    public Optional<T> empty() {
        return Optional.empty();
    }

    @Override
    public T combine(T a, T b) {
        return null;
    }

    @Override
    public <R> Functor<R> map(Function<T, R> mapper) {
        return new FunctorType<>(mapper.apply(value));
    }

    @Override
    public Boolean eq(T other) {
        return value.equals(other);
    }

    public static <T> Functor<T> of(T value) {
        return new FunctorType<>(value);
    }

    @Override
    public String toString() {
        return "FunctorType{" +
                "value = " + value +
                '}';
    }
}
