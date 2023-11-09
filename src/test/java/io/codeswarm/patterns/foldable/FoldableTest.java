package io.codeswarm.patterns.foldable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.function.BiFunction;

class FoldableTest {

    List<Integer> intList;
    FoldableType<Integer, Integer> foldable;

    @BeforeEach
    public void setUp() {
        intList = List.of(1, 2, 3, 4, 5);
        foldable = new FoldableType<>(0, 0);
    }

    @Test
    public void testFoldLeft() {

        // Define an accumulator that adds two integers
        BiFunction<Integer, Integer, Integer> accumulator = Integer::sum;

        // Test the foldLeft method
        int result = foldable.foldLeft(intList, 0, accumulator);
        assertEquals(15, result);
    }

    @Test
    public void testFoldRight() {

        // Define an accumulator that adds two integers
        BiFunction<Integer, Integer, Integer> accumulator = Integer::sum;

        // Test the foldRight method
        int result = foldable.foldRight(intList, 0, accumulator);
        assertEquals(15, result);
    }

    @Test
    public void testHead() {

        // Test the head method
        Integer result = FoldableType.head(intList);
        assertEquals(1, result);
    }

    @Test
    public void testTail() {

        // Test the tail method
        List<Integer> result = FoldableType.tail(intList);
        assertEquals(List.of(2, 3, 4, 5), result);
    }
}