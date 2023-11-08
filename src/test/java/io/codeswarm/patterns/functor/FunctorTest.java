package io.codeswarm.patterns.functor;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class FunctorTest {

    @Test
    public void functorMapToStringTest() {
        Functor<Integer> functor = new FunctorType<>(35);
        Function<Integer, String> mapper = Objects::toString;
        String result = functor.map(mapper).toString();
        assertEquals("FunctorType{value = 35}", result);
    }

    @Test
    public void functorEqTEst() {
        Functor<String> functor = new FunctorType<>("Functional design pattern");
        assertTrue(functor.eq("Functional design pattern"));
        assertFalse(functor.eq("Functor"));
    }
}
