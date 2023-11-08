package io.codeswarm.patterns.applicative;

import io.codeswarm.patterns.functor.Functor;
import org.junit.jupiter.api.Test;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicativeTest {

    @Test
    public void testPure() {
        Integer value = 2;
        Applicative<Integer> applicative = new ApplicativeType<>(value);
        assertEquals(value, Integer.valueOf(applicative.pure(value).toString()));
    }

    @Test
    public void testAp() {
        Applicative<Integer> applicative = new ApplicativeType<>(5);
        ApplicativeType<Function<Integer, String>> transformer = new ApplicativeType<>(x -> "Result: " + x);
        Applicative<String> result = applicative.ap(transformer);
        assertEquals("Result: 5", result.toString());
    }

    @Test
    public void testMap() {
        Integer value = 42;
        Applicative<Integer> applicative = new ApplicativeType<>(value);
        Function<Integer, String> mapper = String::valueOf;
        Functor<String> result = applicative.map(mapper);
        assertEquals("42", result.toString());
    }

    @Test
    public void testEq() {
        Integer value = 42;
        Applicative<Integer> applicative = new ApplicativeType<>(value);
        assertTrue(applicative.eq(42));
        assertFalse(applicative.eq(43));
    }
}
