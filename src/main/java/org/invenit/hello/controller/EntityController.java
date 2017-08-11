package org.invenit.hello.controller;

import org.invenit.hello.dto.converter.EntityConverter;
import org.invenit.hello.dto.model.EntityDto;
import org.invenit.hello.entity.Entity;
import org.invenit.hello.service.EntityService;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@RestController
@RequestMapping("/api/entity")
public class EntityController {

    private EntityService entityService;
    private EntityConverter entityConverter;

    @Autowired
    public EntityController(EntityService entityService, EntityConverter entityConverter) {
        this.entityService = entityService;
        this.entityConverter = entityConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody EntityDto dto) {
        if (dto == null) {
            return ResponseEntity.badRequest().body("Empty content");
        } else {
            Entity model = entityConverter.convertFrom(dto);
            entityService.add(model);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage() {
        Page<Entity> page = entityService.get(new PageRequest(0, 50));
        Page<EntityDto> result = page.map(entityConverter::convertTo);
        return ResponseEntity.ok(result);
    }
}
