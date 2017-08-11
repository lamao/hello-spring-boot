package org.invenit.hello.dto.model;

import java.util.List;
import java.util.UUID;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class EntityTypeDto {
    public UUID id;
    public String code;
    public List<PropertyDefinitionDto> propertyDefinitions;
}
