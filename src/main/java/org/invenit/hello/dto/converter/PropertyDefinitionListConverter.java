package org.invenit.hello.dto.converter;

import org.invenit.hello.dto.model.PropertyDefinitionDto;
import org.invenit.hello.entity.PropertyDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Component
public class PropertyDefinitionListConverter extends ListConverter<PropertyDefinition, PropertyDefinitionDto> {

    @Autowired
    public PropertyDefinitionListConverter(
                    Converter<PropertyDefinition, PropertyDefinitionDto> itemConverter) {
        super(itemConverter);
    }
}
