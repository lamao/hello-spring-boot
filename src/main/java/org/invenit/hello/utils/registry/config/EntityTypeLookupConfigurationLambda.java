package org.invenit.hello.utils.registry.config;

import org.invenit.hello.utils.registry.Registry;
import org.invenit.hello.utils.registry.builder.EntityTypeRegexpLookup;

import java.util.function.Function;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class EntityTypeLookupConfigurationLambda {
    private static Registry<Function<String, String>> lookup;
    static {
        lookup = new EntityTypeRegexpLookup<Function<String, String>>().when()
            .resource((value) -> String.format("[RESOURCE] %s", value))
            .user((value) -> String.format("[USER] %s", value))
            .build();
    }

    public static Registry<Function<String, String>> get() {
        return lookup;
    }
}
