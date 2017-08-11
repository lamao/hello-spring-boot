package org.invenit.hello.repository;

import org.invenit.hello.entity.PropertyDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Repository
public interface PropertyDefinitionRepository extends JpaRepository<PropertyDefinition, UUID> {
    PropertyDefinition findByCode(String code);

    List<PropertyDefinition> findByEntityTypeId(UUID entityTypeId);
}
