package io.codeswarm.patterns.applicative;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ApplicativeType<T> implements Applicative<T> {

    private final T value;

    private final BinaryOperator<T> operation;

    public ApplicativeType(T value) {
        this.value = value;
        this.operation = (a, b) -> a;
    }

    public static <T> Applicative<T> of(T value) {
        return new ApplicativeType<>(value);
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
    public Applicative<T> pure(T value) {
        return new ApplicativeType<>(value);
    }

    @Override
    public <R> Applicative<R> ap(ApplicativeType<Function<T, R>> transformer) {
        return new ApplicativeType<>(transformer.value.apply(value));
    }

    @Override
    public <R> Applicative<R> map(Function<T, R> mapper) {
        return new ApplicativeType<>(mapper.apply(value));
    }

    @Override
    public Boolean eq(T other) {
        return value.equals(other);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
