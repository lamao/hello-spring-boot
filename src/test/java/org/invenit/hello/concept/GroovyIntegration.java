package org.invenit.hello.concept;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class GroovyIntegration {

    @Test
    public void testGroovyScript() {
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);

        Map<String, Object> request = new HashMap<>();
        request.put("foo", "bar");
        request.put("bar", 1234L);
        binding.setVariable("request", request);

        Object response = shell.evaluate("println request.foo; println request.bar; println 'Hello'; 'Twin Pix'");
        System.out.println(response);
    }
}
