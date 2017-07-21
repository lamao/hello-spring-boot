package org.invenit.hello.service.impl;

import org.invenit.hello.entity.Entity;
import org.invenit.hello.repository.EntityRepository;
import org.invenit.hello.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityRepository entityRepository;

    @Override
    public void add(Entity entity) {
        entityRepository.save(entity);
    }

    @Override
    public Page<Entity> get(PageRequest request) {
        return entityRepository.findAll(request);
    }
}
