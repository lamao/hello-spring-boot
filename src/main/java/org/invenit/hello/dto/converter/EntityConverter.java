package org.invenit.hello.dto.converter;

import org.invenit.hello.dto.model.EntityDto;
import org.invenit.hello.entity.Entity;
import org.mapstruct.Mapper;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Mapper(componentModel = "spring", uses = {EntityTypeConverter.class, PropertyConverter.class})
public interface EntityConverter extends Converter<Entity, EntityDto> {

    @Override
    EntityDto convertTo(Entity entity);

    @Override
    Entity convertFrom(EntityDto entityDto);
}
