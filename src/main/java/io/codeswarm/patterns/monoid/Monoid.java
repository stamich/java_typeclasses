package io.codeswarm.patterns.monoid;

import io.codeswarm.patterns.semigroup.Semigroup;

import java.util.Optional;

public interface Monoid<T> extends Semigroup<T> {
    Optional<T> empty();
}
