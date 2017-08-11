package org.invenit.hello.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.UUID;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Entity
@Table(name = "property_definition")
public class PropertyDefinition {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_type_id", nullable = false, updatable = false, insertable = false)
    private EntityType entityType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
}
