package org.invenit.hello.service.impl;

import org.invenit.hello.entity.Entity;
import org.invenit.hello.entity.EntityType;
import org.invenit.hello.repository.EntityRepository;
import org.invenit.hello.repository.EntityTypeRepository;
import org.invenit.hello.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Service
public class EntityServiceImpl implements EntityService {

    private EntityRepository entityRepository;
    private EntityTypeRepository entityTypeRepository;

    @Autowired
    public EntityServiceImpl(
                    EntityRepository entityRepository,
                    EntityTypeRepository entityTypeRepository) {
        this.entityRepository = entityRepository;
        this.entityTypeRepository = entityTypeRepository;
    }

    @Override
    public void add(Entity entity) {

        entityRepository.save(entity);
    }

    void enrichBeforeAdd(Entity entity) {
        String typeCode = entity.getType().getCode();
        EntityType entityType = entityTypeRepository.findByCode(typeCode);
        if (entityType == null) {
            throw new IllegalArgumentException(String.format("Entity type [%s] not found", typeCode));
        }
        entity.setType(entityType);
    }

    @Override
    public Page<Entity> get(PageRequest request) {
        return entityRepository.findAll(request);
    }
}
