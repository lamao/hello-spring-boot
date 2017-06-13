package org.invenit.hello.repostiroty;

import org.invenit.hello.entity.DomainObject;

import java.util.Set;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface DataRepository<V extends DomainObject> {

    void persist(V object);

    void delete(V object);

    Set<String> getRandomData();

}
