package org.invenit.hello.service.impl;

import org.invenit.hello.entity.Entity;
import org.invenit.hello.entity.EntityType;
import org.invenit.hello.entity.PropertyDefinition;
import org.invenit.hello.repository.EntityRepository;
import org.invenit.hello.repository.EntityTypeRepository;
import org.invenit.hello.repository.PropertyDefinitionRepository;
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
    private PropertyDefinitionRepository propertyDefinitionRepository;

    @Autowired
    public EntityServiceImpl(
                    EntityRepository entityRepository,
                    EntityTypeRepository entityTypeRepository,
                    PropertyDefinitionRepository propertyDefinitionRepository) {
        this.entityRepository = entityRepository;
        this.entityTypeRepository = entityTypeRepository;
        this.propertyDefinitionRepository = propertyDefinitionRepository;
    }

    @Override
    public void add(Entity entity) {
        entityRepository.save(entity);
        enrichBeforeAdd(entity);
    }

    private void enrichBeforeAdd(Entity entity) {
        String typeCode = entity.getType().getCode();
        EntityType entityType = entityTypeRepository.findByCode(typeCode);
        if (entityType == null) {
            throw new IllegalArgumentException(
                            String.format("Entity type [%s] not found", typeCode));
        }
        entity.setType(entityType);

        entity.getProperties().forEach((it) -> {
            String propertyCode = it.getDefinition().getCode();
            PropertyDefinition definition = propertyDefinitionRepository.findByCode(propertyCode);
            if (definition == null) {
                throw new IllegalArgumentException(String.format("Property [%s] not found", propertyCode));
            }
            it.setDefinition(definition);
        });
    }

    @Override
    public Page<Entity> get(PageRequest request) {
        return entityRepository.findAll(request);
    }
}
