package org.invenit.hello.config;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("Invenit");
        super.afterPropertiesSet();
    }
}
