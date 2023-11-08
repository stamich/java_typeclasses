package io.codeswarm.patterns.monoid;

import java.util.Optional;
import java.util.function.BinaryOperator;

public class MonoidType<T> implements Monoid<T> {

    private final T value;
    private final BinaryOperator<T> operation;

    public MonoidType(T value, BinaryOperator<T> operation) {
        this.value = value;
        this.operation = operation;
    }

    @Override
    public Optional<T> empty() {
        return Optional.ofNullable(value);
    }

    @Override
    public T combine(T a, T b) {
        return operation.apply(a, b);
    }

    public static <T> Monoid<T> of(T value, BinaryOperator<T> operation) {
        return new MonoidType<>(value, operation);
    }
}
