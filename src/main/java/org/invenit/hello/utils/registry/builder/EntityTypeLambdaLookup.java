package org.invenit.hello.utils.registry.builder;

import java.util.function.Predicate;

import org.invenit.hello.utils.registry.LambdaRegistry;
import org.invenit.hello.utils.registry.Registry;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class EntityTypeLambdaLookup<V> implements EntityTypeLookup<V> {
    private static final Predicate<String> RESOURCE_PREDICATE = (v) -> v.startsWith("RESOURCE");
    private static final Predicate<String> USER_PREDICATE = "USER"::equals;

    private LambdaRegistry<V> registry;

    @Override
    public EntityTypeLambdaLookup<V> when() {
        registry = new LambdaRegistry<V>();
        return this;
    }

    @Override
    public Registry<V> build() {
        return registry;
    }

    @Override
    public EntityTypeLambdaLookup<V> resource(V value) {
        registry.put(RESOURCE_PREDICATE, value);
        return this;
    }

    @Override
    public EntityTypeLambdaLookup<V> user(V value) {
        registry.put(USER_PREDICATE, value);
        return this;
    }

}
