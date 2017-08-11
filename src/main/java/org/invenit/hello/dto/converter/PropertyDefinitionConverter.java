package org.invenit.hello.dto.converter;

import org.invenit.hello.dto.model.PropertyDefinitionDto;
import org.invenit.hello.entity.PropertyDefinition;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Mapper(componentModel = "spring")
public interface PropertyDefinitionConverter extends Converter<PropertyDefinition, PropertyDefinitionDto> {

    @Override
    PropertyDefinitionDto convertTo(PropertyDefinition propertyDefinition);

    @Override
    PropertyDefinition convertFrom(PropertyDefinitionDto propertyDefinitionDto);
}
