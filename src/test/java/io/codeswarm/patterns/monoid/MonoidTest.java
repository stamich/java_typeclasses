package io.codeswarm.patterns.monoid;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonoidTest {

    @Test
    public void monoidEmptyTest() {
        Monoid<Integer> monoid = new MonoidType<>(0, Integer::sum);
        Optional<Integer> result = monoid.empty();
        assertEquals(0, result.orElseThrow());
    }

    @Test
    public void monoidCombineTest() {
        Monoid<Integer> monoid = new MonoidType<>(0, Integer::sum);
        int result = monoid.combine(3, 4);
        assertEquals(7, result);
    }

    @Test
    public void MonoidOfTest() {
        Monoid<Integer> monoid = MonoidType.of(0, Integer::sum);
        Optional<Integer> result = monoid.empty();
        assertEquals(0, result.orElseThrow());
    }
}
