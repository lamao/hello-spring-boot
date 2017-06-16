package org.invenit.hello.utils.registry;

import org.invenit.hello.utils.registry.builder.EntityTypeRegexpLookup;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class EntityTypeRegexpLookupTest {


    @Test
    public void testSimpleLookup() {
        Registry<String> lookup = new EntityTypeRegexpLookup<String>()
            .when()
            .resource("RESOURCE")
            .user("USER")
            .build();

        assertEquals("RESOURCE", lookup.find("RESOURCE_1").orElse(null));
        assertEquals("USER", lookup.find("USER").orElse(null));
    }

    @Test
    public void testLambdaLookup() {
        Registry<Function<Long, String>> lookup = new EntityTypeRegexpLookup<Function<Long, String>>()
            .when()
            .resource(v -> "RESOURCE_" + v)
            .user(v -> "USER_" + v)
            .build();

        assertEquals("RESOURCE_1", lookup.find("RESOURCE_ANY").orElse(null).apply(1L));
        assertEquals("USER_2", lookup.find("USER").orElse(null).apply(2L));
    }

}