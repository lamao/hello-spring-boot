package org.invenit.hello.service.impl;

import org.invenit.hello.entity.PropertyDefinition;
import org.invenit.hello.repository.PropertyDefinitionRepository;
import org.invenit.hello.service.PropertyDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Service
public class PropertyDefinitionServiceImpl implements PropertyDefinitionService {

    private PropertyDefinitionRepository propertyDefinitionRepository;

    @Autowired
    public PropertyDefinitionServiceImpl(PropertyDefinitionRepository propertyDefinitionRepository) {
        this.propertyDefinitionRepository = propertyDefinitionRepository;
    }

    @Override
    public void add(PropertyDefinition entity) {
        propertyDefinitionRepository.save(entity);
    }

    @Override
    public Page<PropertyDefinition> get(PageRequest request) {
        return propertyDefinitionRepository.findAll(request);
    }
}
