package org.invenit.hello.repository;

import java.util.UUID;

import org.invenit.hello.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {}
