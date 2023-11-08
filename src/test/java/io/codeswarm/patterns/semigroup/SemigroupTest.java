package io.codeswarm.patterns.semigroup;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SemigroupTest {

    @Test
    public void semigroupIntegerTest() {
        BinaryOperator<Integer> additionOfInts = Integer::sum;
        Semigroup<Integer> semigroup = new SemigroupType<>(additionOfInts);
        var result = semigroup.combine(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void semigroupDoubleTest() {
        BinaryOperator<Double> multiplicationOfDoubles = (a,b) -> a * b;
        Semigroup<Double> semigroup = new SemigroupType<>(multiplicationOfDoubles);
        var result = semigroup.combine(4.0, 5.0);
        assertEquals(20, result);
    }

    @Test
    public void semigroupStringTest() {
        BinaryOperator<String> concatenation = String::concat;
        Semigroup<String> semigroup = new SemigroupType<>(concatenation);
        var result = semigroup.combine("Type ", "class");
        assertEquals("Type class", result);
    }
}
