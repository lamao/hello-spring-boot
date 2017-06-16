package org.invenit.hello.utils.registry.config;

import org.invenit.hello.utils.registry.Registry;
import org.invenit.hello.utils.registry.builder.EntityTypeRegexpLookup;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class EntityTypeLookupConfigurationSimple {
    private static Registry<String> lookup;
    static {
        lookup = new EntityTypeRegexpLookup<String>().when()
            .resource("RESOURCE")
            .user("USER")
            .build();
    }

    public static Registry<String> get() {
        return lookup;
    }
}
