package io.codeswarm.patterns.monad;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class MonadTest {

    @Test
    public void testMap() {
        Monad<Integer> monad = new MonadType<>(5);
        Function<Integer, String> mapper = Objects::toString;
        String result = monad.map(mapper).toString();
        assertEquals("MonadType{value = 5}", result);
    }

    @Test
    public void testEq() {
        Monad<Integer> monad = new MonadType<>(5);
        assertTrue(monad.eq(5));
        assertFalse(monad.eq(10));
    }

    @Test
    public void testPure() {
        Monad<Integer> monad = new MonadType<>(5);
        Monad<Integer> result = monad.pure(10);
        assertEquals("MonadType{value = 10}", result.toString());
    }

//    @Test
//    public void testAp() {
//        Monad<Integer> monad = new MonadType<>(5);
//        Monad<Function<Integer, String>> transformer = new MonadType<>(x -> "Result: " + x);
//        Monad<String> result = monad.ap(transformer);
//        assertEquals("Result: 5", result.toString());
//    }
//
//    @Test
//    public void testFlatMap() {
//        Monad<Integer> monad = new MonadType<>(5);
//        Monad<Integer> result = monad.flatMap(x -> new MonadType<>(x * 2));
//        assertEquals("MonadType{value = 10}", result.toString());
//    }
}
