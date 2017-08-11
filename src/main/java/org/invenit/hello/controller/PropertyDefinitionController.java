package org.invenit.hello.controller;

import org.invenit.hello.dto.converter.PropertyDefinitionConverter;
import org.invenit.hello.dto.model.PropertyDefinitionDto;
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

    private PropertyDefinitionConverter propertyDefinitionConverter;

    @Autowired
    public PropertyDefinitionController(
                    PropertyDefinitionService propertyDefinitionService,
                    PropertyDefinitionConverter propertyDefinitionConverter) {
        this.propertyDefinitionService = propertyDefinitionService;
        this.propertyDefinitionConverter = propertyDefinitionConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody PropertyDefinitionDto dto) {
        if (dto == null) {
            return ResponseEntity.badRequest().body("Empty content");
        } else {
            PropertyDefinition model = propertyDefinitionConverter.convertFrom(dto);
            propertyDefinitionService.add(model);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage() {
        Page<PropertyDefinition> page = propertyDefinitionService.get(new PageRequest(0, 100));
        Page<PropertyDefinitionDto> result = page.map(propertyDefinitionConverter::convertTo);
        return ResponseEntity.ok(result);
    }
}
