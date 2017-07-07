package org.invenit.hello.service;

import org.invenit.hello.entity.Data;
import org.springframework.data.domain.Page;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface DataService {

    void persist(Data data);

    Page<Data> getRandomData();
}
