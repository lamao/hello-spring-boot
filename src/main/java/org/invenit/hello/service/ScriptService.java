package org.invenit.hello.service;

import org.invenit.hello.entity.Script;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
public interface ScriptService {
    Page<Script> get(PageRequest request);

    Script get(String code);

    void add(Script script);

    void remove(String code);
}
