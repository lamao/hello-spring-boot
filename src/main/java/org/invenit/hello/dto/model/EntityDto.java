package org.invenit.hello.dto.model;

import java.util.List;
import java.util.UUID;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class EntityDto {
    public UUID id;
    public EntityTypeDto type;
    public List<PropertyDto> properties;
}
