package org.invenit.hello.controller;

import org.invenit.hello.entity.PropertyDefinition;
import org.invenit.hello.service.PropertyDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@RestController
@RequestMapping("/api/property-definition")
public class PropertyDefinitionController {

    private PropertyDefinitionService propertyDefinitionService;

    @Autowired
    public PropertyDefinitionController(PropertyDefinitionService propertyDefinitionService) {
        this.propertyDefinitionService = propertyDefinitionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody PropertyDefinition entityType) {
        if (entityType == null) {
            return ResponseEntity.badRequest().body("Empty content");
        } else {
            propertyDefinitionService.add(entityType);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage() {
        Page<PropertyDefinition> page = propertyDefinitionService.get(new PageRequest(0, 100));
        return ResponseEntity.ok(page);
    }
}
