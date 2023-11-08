package io.codeswarm.patterns.monad;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class MonadType<T> implements Monad<T>{

    private final T value;

    private final BinaryOperator<T> operation;

    public MonadType(T value) {
        this.value = value;
        this.operation = (a, b) -> a;
    }

    @Override
    public Optional<T> empty() {
        return Optional.empty();
    }

    @Override
    public T combine(T a, T b) {
        return operation.apply(a, b);
    }

    @Override
    public <R> Monad<R> map(Function<T, R> mapper) {
        return new MonadType<>(mapper.apply(value));
    }

    @Override
    public Boolean eq(T other) {
        return value.equals(other);
    }

    @Override
    public Monad<T> pure(T value) {
        return new MonadType<>(value);
    }

    @Override
    public <R> Monad<R> ap(MonadType<Function<T, R>> transformer) {
        return new MonadType<>(transformer.value.apply(value));
    }

    @Override
    public <R> Monad<R> flatMap(Function<T, Function<T, R>> mapper) {
        return new MonadType<>(mapper.apply(value).apply(value));
    }

    public static <T> Monad<T> of(T value) {
        return new MonadType<>(value);
    }

    @Override
    public String toString() {
        return "MonadType{" +
                "value = " + value +
                '}';
    }
}
