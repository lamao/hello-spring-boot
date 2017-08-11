package org.invenit.hello.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public class ListConverter<SRC, DST> implements Converter<List<SRC>, List<DST>> {
    private Converter<SRC, DST> itemConverter;

    public ListConverter(
                    Converter<SRC, DST> itemConverter) {
        this.itemConverter = itemConverter;
    }

    @Override
    public List<DST> convertTo(List<SRC> src) {
        return src.stream().map(itemConverter::convertTo).collect(Collectors.toList());
    }

    @Override
    public List<SRC> convertFrom(List<DST> src) {
        return src.stream().map(itemConverter::convertFrom).collect(Collectors.toList());
    }
}
