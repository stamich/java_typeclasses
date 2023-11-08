package io.codeswarm.patterns.invariant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvariantTest {

    @Test
    public void testImapWithMapper() {
        InvariantType<Integer, String> invariant = new InvariantType<>(42, null);
        Invariant<Integer, String> mappedInvariant = invariant.imap(Object::toString, null);

        assertNotNull(mappedInvariant);
        assertEquals("InvariantType{value=42, reversedValue=null}", mappedInvariant.toString());
    }

    @Test
    public void testImapWithReversedMapper() {
        InvariantType<Integer, String> invariant = new InvariantType<>(null, "42");
        Invariant<Integer, String> mappedInvariant = invariant.imap(null, Integer::parseInt);

        assertNotNull(mappedInvariant);
        assertEquals("InvariantType{value=null, reversedValue=42}", mappedInvariant.toString());
    }

    @Test
    public void testImapWithBothMappersNull() {
        InvariantType<Integer, String> invariant = new InvariantType<>(42, "42");
        Invariant<Integer, String> mappedInvariant = invariant.imap(null, null);

        assertNotNull(mappedInvariant);
        assertNotNull(mappedInvariant.imap(null, null));
    }
}
