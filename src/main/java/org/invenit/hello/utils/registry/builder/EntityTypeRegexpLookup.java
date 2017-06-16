package org.invenit.hello.utils.registry.builder;

import org.invenit.hello.utils.registry.RegexpRegistry;
import org.invenit.hello.utils.registry.Registry;

import java.util.regex.Pattern;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class EntityTypeRegexpLookup<V> implements EntityTypeLookup<V> {
    private static final Pattern RESOURCE_PATTERN = Pattern.compile("^RESOURCE.*");
    private static final Pattern USER_PATTERN = Pattern.compile("USER");

    private RegexpRegistry<V> regexpLookup;

    @Override
    public EntityTypeRegexpLookup<V> when() {
        regexpLookup = new RegexpRegistry<V>();
        return this;
    }

    @Override
    public Registry<V> build() {
        return regexpLookup;
    }

    @Override
    public EntityTypeRegexpLookup<V> resource(V value) {
        regexpLookup.put(RESOURCE_PATTERN, value);
        return this;
    }

    @Override
    public EntityTypeRegexpLookup<V> user(V value) {
        regexpLookup.put(USER_PATTERN, value);
        return this;
    }

}
