package org.invenit.hello.service;

import java.util.Set;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface DataService {

    void persist(String problem);

    Set<String> getRandomData();
}
