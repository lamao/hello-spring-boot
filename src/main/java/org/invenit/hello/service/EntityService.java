package org.invenit.hello.service;

import org.invenit.hello.entity.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface EntityService {
    void add(Entity entity);

    Page<Entity> get(PageRequest request);

    Entity get(Long id);

    void remove(Long id);
}
