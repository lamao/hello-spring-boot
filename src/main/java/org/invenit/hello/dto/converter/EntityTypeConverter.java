package org.invenit.hello.dto.converter;

import org.invenit.hello.dto.model.EntityTypeDto;
import org.invenit.hello.entity.EntityType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Mapper(componentModel = "spring", uses = {PropertyDefinitionConverter.class})
public interface EntityTypeConverter extends Converter<EntityType, EntityTypeDto> {

    @Override
    EntityTypeDto convertTo(EntityType entityType);

    @Override
    EntityType convertFrom(EntityTypeDto entityTypeDto);
}
