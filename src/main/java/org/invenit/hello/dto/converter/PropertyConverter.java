package org.invenit.hello.dto.converter;

import org.invenit.hello.dto.model.PropertyDto;
import org.invenit.hello.entity.Property;
import org.mapstruct.Mapper;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Mapper(componentModel = "spring", uses = {PropertyDefinitionConverter.class})
public interface PropertyConverter extends Converter<Property, PropertyDto> {

    @Override
    PropertyDto convertTo(Property property);

    @Override
    Property convertFrom(PropertyDto propertyDto);
}
