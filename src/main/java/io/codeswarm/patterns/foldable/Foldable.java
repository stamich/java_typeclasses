package io.codeswarm.patterns.foldable;

import java.util.List;
import java.util.function.BiFunction;

public interface Foldable<T, U> {

    U foldLeft(List<T> list, U initialValue, BiFunction<U, T, U> accumulator);
    U foldRight(List<T> list, U initialValue, BiFunction<T, U, U> accumulator);
}
