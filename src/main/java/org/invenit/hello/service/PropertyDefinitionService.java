package org.invenit.hello.service;

import org.invenit.hello.entity.PropertyDefinition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface PropertyDefinitionService {
    void add(PropertyDefinition PropertyDefinition);

    Page<PropertyDefinition> get(PageRequest request);
}
