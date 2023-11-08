package io.codeswarm.patterns.apply;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ApplyType<T> implements Apply<T> {

    private final T value;

    private final BinaryOperator<T> operation;

    public ApplyType(T value) {
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
    public <R> Apply<R> ap(ApplyType<Function<T,R>> transformer) {
        return new ApplyType<>(transformer.value.apply(value));
    }

    @Override
    public <R> Apply<R> map(Function<T, R> mapper) {
        return new ApplyType<>(mapper.apply(value));
    }

    @Override
    public Boolean eq(T other) {
        return value.equals(other);
    }

    public static <T> Apply<T> of(T value) {
        return new ApplyType<>(value);
    }

    @Override
    public String toString() {
        return "ApplyType{" +
                "value = " + value +
                '}';
    }
}
