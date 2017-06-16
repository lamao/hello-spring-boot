package org.invenit.hello.utils.registry;

import java.util.Optional;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface Registry<V> {
    /**
     * Looks for a pattern matching the given string, and returns the associated
     * value. If not match is found, returns {@link Optional#empty()}.
     */
    Optional<V> find(String string);
}
