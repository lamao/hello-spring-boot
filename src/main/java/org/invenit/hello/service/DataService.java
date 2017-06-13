package org.invenit.hello.service;

import java.util.Set;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface DataService {

    public boolean persist(String problem);

    public Set<String> getRandomData();
}
