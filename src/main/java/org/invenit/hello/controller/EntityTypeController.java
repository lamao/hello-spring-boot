package org.invenit.hello.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.invenit.hello.dto.converter.EntityTypeConverter;
import org.invenit.hello.dto.converter.PropertyDefinitionConverter;
import org.invenit.hello.dto.model.EntityTypeDto;
import org.invenit.hello.dto.model.PropertyDefinitionDto;
import org.invenit.hello.entity.EntityType;
import org.invenit.hello.entity.PropertyDefinition;
import org.invenit.hello.service.EntityTypeService;
import org.invenit.hello.service.PropertyDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@RestController
@RequestMapping("/api/entity-type")
public class EntityTypeController {

    private EntityTypeService entityTypeService;
    private PropertyDefinitionService propertyDefinitionService;

    private EntityTypeConverter entityTypeConverter;
    private PropertyDefinitionConverter propertyDefinitionConverter;

    @Autowired
    public EntityTypeController(
                    EntityTypeService entityTypeService,
                    PropertyDefinitionService propertyDefinitionService,
                    EntityTypeConverter entityTypeConverter,
                    PropertyDefinitionConverter propertyDefinitionConverter) {
        this.entityTypeService = entityTypeService;
        this.propertyDefinitionService = propertyDefinitionService;
        this.entityTypeConverter = entityTypeConverter;

        this.propertyDefinitionConverter = propertyDefinitionConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody EntityTypeDto dto) {
        if (dto == null) {
            return ResponseEntity.badRequest().body("Empty content");
        } else {
            EntityType model = entityTypeConverter.convertFrom(dto);
            entityTypeService.add(model);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage() {
        Page<EntityType> page = entityTypeService.get(new PageRequest(0, 100));
        Page<EntityTypeDto> result = page.map(entityTypeConverter::convertTo);
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOne(@PathVariable("id") Long id) {
        EntityType model = entityTypeService.get(id);
        EntityTypeDto dto = entityTypeConverter.convertTo(model);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(path = "/{id}/property-definitions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPropertyDefinitions(@PathVariable("id") Long id) {
        List<PropertyDefinition> propertyDefinitions = propertyDefinitionService
                        .getByEntityTypeId(id);
        List<PropertyDefinitionDto> result = propertyDefinitions.stream()
                        .map(propertyDefinitionConverter::convertTo).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        entityTypeService.remove(id);
        return ResponseEntity.ok().build();
    }
}
