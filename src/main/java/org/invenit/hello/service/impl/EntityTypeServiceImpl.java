package org.invenit.hello.service.impl;

import org.invenit.hello.entity.EntityType;
import org.invenit.hello.repository.EntityTypeRepository;
import org.invenit.hello.service.EntityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Service
public class EntityTypeServiceImpl implements EntityTypeService {

    @Autowired
    private EntityTypeRepository entityTypeRepository;

    @Override
    public void add(EntityType entityType) {
        entityTypeRepository.save(entityType);
    }

    @Override
    public Page<EntityType> get(PageRequest request) {
        return entityTypeRepository.findAll(request);
    }
}
