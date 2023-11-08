package io.codeswarm.patterns.semigroup;

import java.util.function.BinaryOperator;

public class SemigroupType<T> implements Semigroup<T> {

    private final BinaryOperator<T> operation;

    public SemigroupType(BinaryOperator<T> operation) {
        this.operation = operation;
    }

    @Override
    public T combine(T a, T b) {
        return operation.apply(a, b);
    }
}
