package org.invenit.hello.utils.registry.builder;

import org.invenit.hello.utils.registry.RegexpRegistry;
import org.invenit.hello.utils.registry.Registry;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface EntityTypeLookup<V> {

    EntityTypeLookup<V> when();

    Registry<V> build();

    EntityTypeLookup<V> resource(V value);

    EntityTypeLookup<V> user(V value);
}
