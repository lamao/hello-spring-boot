package org.invenit.hello.controller;

import org.invenit.hello.entity.EntityType;
import org.invenit.hello.service.EntityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@RestController
@RequestMapping("/api/entity-type")
public class EntityTypeController {

    @Autowired
    private EntityTypeService entityTypeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody EntityType entityType) {
        if (entityType == null) {
            return ResponseEntity.badRequest().body("Empty content");
        } else {
            entityTypeService.add(entityType);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage() {
        Page<EntityType> page = entityTypeService.get(new PageRequest(0, 100));
        return ResponseEntity.ok(page);
    }
}
