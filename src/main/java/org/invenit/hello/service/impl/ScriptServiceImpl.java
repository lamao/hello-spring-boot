package org.invenit.hello.service.impl;

import org.invenit.hello.entity.Script;
import org.invenit.hello.repository.ScriptRepository;
import org.invenit.hello.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Service
public class ScriptServiceImpl implements ScriptService {

    private ScriptRepository scriptRepository;

    @Autowired
    public ScriptServiceImpl(ScriptRepository scriptRepository) {
        this.scriptRepository = scriptRepository;
    }

    @Override
    public Page<Script> get(PageRequest request) {
        return scriptRepository.findAll(request);
    }

    @Override
    public Script get(String code) {
        return null;
    }

    @Override
    public void add(Script script) {

    }

    @Override
    public void remove(String code) {

    }
}
