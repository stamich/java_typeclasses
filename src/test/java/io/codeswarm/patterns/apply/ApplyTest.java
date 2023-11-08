package io.codeswarm.patterns.apply;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplyTest {

    @Test
    public void applyApTest() {
        ApplyType<Integer> applyType = new ApplyType<>(5);
        ApplyType<Function<Integer, String>> transformer = new ApplyType<>(x -> "Result: " + x);

        Apply<String> result = applyType.ap(transformer);
        assertEquals("ApplyType{value = Result: 5}", result.toString());
    }

    @Test
    public void applyMapTest() {
        ApplyType<Integer> applyType = new ApplyType<>(10);

        Function<Integer, String> mapper = x -> "Value: " + x;
        Apply<String> result = applyType.map(mapper);

        assertEquals("ApplyType{value = Value: 10}", result.toString());
    }

    @Test
    public void applyEqTest() {
        ApplyType<Integer> applyType = new ApplyType<>(15);
        Boolean isEqual = applyType.eq(15);

        assertTrue(isEqual);
    }

}
