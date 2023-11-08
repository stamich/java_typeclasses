package io.codeswarm.patterns.invariant;

import java.util.Optional;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public class InvariantType<T,R> implements Invariant<T,R>{

    private final T value;
    private final R reversedValue;

    public InvariantType(T value, R reversedValue) {
        this.value = value;
        this.reversedValue = reversedValue;
    }

    @Override
    public Invariant<T,R> imap(Function<T,R> mapper, Function<R,T> reversedMapper) {
        if (mapper != null && reversedMapper == null) {
            return (Invariant<T, R>) new InvariantType<>(mapper.apply(value), null);
        }
        if (mapper == null && reversedMapper != null) {
            return (Invariant<T, R>) new InvariantType<>(null, reversedMapper.apply(reversedValue));
        }
        else {
            return empty();
        }
    }

    private Invariant<T,R> empty() {
        return new InvariantType<>((T) Optional.empty(), (R) Optional.empty());
    }
}
