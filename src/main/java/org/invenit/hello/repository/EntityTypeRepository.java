package org.invenit.hello.repository;

import org.invenit.hello.entity.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Repository
public interface EntityTypeRepository extends JpaRepository<EntityType, Long> {

    EntityType findByCode(String code);
}
