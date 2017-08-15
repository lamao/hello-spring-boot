package org.invenit.hello.repository;

import java.util.List;

import org.invenit.hello.entity.PropertyDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Repository
public interface PropertyDefinitionRepository extends JpaRepository<PropertyDefinition, Long> {
    PropertyDefinition findByCode(String code);

    List<PropertyDefinition> findByEntityTypeId(Long entityTypeId);
}
