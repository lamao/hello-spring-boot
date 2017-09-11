package org.invenit.hello.service;

import org.invenit.hello.entity.EntityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface EntityTypeService {
    void add(EntityType entity);

    Page<EntityType> get(PageRequest request);

    EntityType get(Long id);

    void remove(Long id);
}
