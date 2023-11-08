package io.codeswarm.patterns.foldable;

import java.util.*;
import java.util.function.BiFunction;

public class FoldableType<T,U> implements Foldable<T,U> {

    public final T firstValue;
    public final U secondValue;

    public FoldableType(T firstValue, U secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public static <T> T head(List<T> list) {
        return !list.isEmpty()
                ? list.get(0)
                : null;
    }

    public static <T> List<T> tail(List<T> list) {
        List<T> workList = copy(list);
        workList.remove(0);
        return !list.isEmpty()
                ? Collections.unmodifiableList(workList)
                : null;
    }

    private static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }

    @Override
    public U foldLeft(List<T> list, U initialValue, BiFunction<U, T, U> accumulator) {
        U result = initialValue;
        for (T element: list) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    @Override
    public U foldRight(List<T> list, U initialValue, BiFunction<T, U, U> accumulator) {
//        if (list.isEmpty()) {
//            return initialValue;
//        } else {
//            T lasElement = list.get(list.size() - 1);
//            List<T> restOfList = list.subList(0, list.size() - 1);
//            U result = accumulator.apply((U) lasElement, (T) accumulator);
//            return foldRight(restOfList, result, accumulator);
//        }
        return list.isEmpty()
                ? initialValue
                : accumulator.apply(head(list), foldRight(tail(list), initialValue, accumulator));
    }


}
