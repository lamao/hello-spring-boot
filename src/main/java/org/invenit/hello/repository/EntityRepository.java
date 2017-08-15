package org.invenit.hello.repository;

import org.invenit.hello.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Repository
public interface EntityRepository extends JpaRepository<Entity, Long> {}
