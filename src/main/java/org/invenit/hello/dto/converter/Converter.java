package org.invenit.hello.dto.converter;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface Converter<SRC, DST> {

    default DST convertTo(SRC src) {
        throw new UnsupportedOperationException("Not implemented");
    }

    default SRC convertFrom(DST dst) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
