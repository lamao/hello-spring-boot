package org.invenit.hello.utils.registry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Associates a series of regular expressions with values, allowing the values
 * to be looked up by strings that match a pattern.
 *
 * Note this is a linear-time operation, and that patterns are checked in
 * insertion order.
 *
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class RegexpRegistry<V> implements Registry<V> {
    // Pattern doesn't override .equals()/.hashCode(), so it can't be the when key
    // use a LinkedHashMap to ensure ordered search
    private final Map<String, Pattern> patterns = new LinkedHashMap<>();
    private final HashMap<String, V> values = new HashMap<>();

    public void put(String regex, V value) {
        put(Pattern.compile(regex), value);
    }

    public void put(Pattern pattern, V value) {
        patterns.put(pattern.pattern(), pattern);
        values.put(pattern.pattern(), value);
    }

    @Override
    public Optional<V> find(String string) {
        for (Map.Entry<String, Pattern> e : patterns.entrySet()) {
            if (e.getValue().matcher(string).matches()) {
                return Optional.of(values.get(e.getKey()));
            }
        }
        return Optional.empty();
    }
}
