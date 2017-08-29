package org.invenit.hello.dto.converter;

import org.invenit.hello.dto.model.ScriptDto;
import org.invenit.hello.entity.Script;
import org.mapstruct.Mapper;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Mapper(componentModel = "spring")
public interface ScriptConverter extends Converter<Script, ScriptDto> {

    @Override
    ScriptDto convertTo(Script entity);

    @Override
    Script convertFrom(ScriptDto dto);
}
