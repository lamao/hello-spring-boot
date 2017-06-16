package org.invenit.hello.utils.registry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class LambdaRegistry<V> implements Registry<V> {
    // Pattern doesn't override .equals()/.hashCode(), so it can't be the when key
    // use a LinkedHashMap to ensure ordered search
    private final HashMap<Predicate<String>, V> values = new HashMap<>();

    public void put(Predicate<String> predicate, V value) {
        values.put(predicate, value);
    }

    @Override
    public Optional<V> find(String string) {
        for (Map.Entry<Predicate<String>, V> e : values.entrySet()) {
            if (e.getKey().test(string)) {
                return Optional.of(e.getValue());
            }
        }
        return Optional.empty();
    }
}
