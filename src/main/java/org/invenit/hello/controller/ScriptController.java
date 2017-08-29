package org.invenit.hello.controller;

import org.invenit.hello.dto.model.ScriptDto;
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
@RequestMapping("/api/script")
public class ScriptController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @GetMapping(path = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOne(@PathVariable String code) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody ScriptDto dto) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @DeleteMapping(path = "{code}")
    public void remove(@PathVariable String code) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
