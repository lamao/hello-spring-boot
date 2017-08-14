package org.invenit.hello.service;

import org.invenit.hello.entity.Entity;
import org.invenit.hello.entity.EntityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface EntityTypeService {
    void add(EntityType entity);

    Page<EntityType> get(PageRequest request);

    void remove(UUID id);
}
