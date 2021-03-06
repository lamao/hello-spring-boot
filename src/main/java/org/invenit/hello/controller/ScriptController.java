package org.invenit.hello.controller;

import org.invenit.hello.dto.converter.ScriptConverter;
import org.invenit.hello.dto.model.ScriptDto;
import org.invenit.hello.entity.Script;
import org.invenit.hello.service.ScriptService;
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
@RequestMapping("/api/script")
public class ScriptController {

    private ScriptService scriptService;

    private ScriptConverter scriptConverter;

    @Autowired
    public ScriptController(
                    ScriptService scriptService,
                    ScriptConverter scriptConverter) {
        this.scriptService = scriptService;
        this.scriptConverter = scriptConverter;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPage() {
        Page<Script> page = scriptService.get(new PageRequest(0, 50));
        Page<ScriptDto> dto = page.map(scriptConverter::convertTo);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(path = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOne(@PathVariable String code) {
        Script entity = scriptService.get(code);
        ScriptDto dto = scriptConverter.convertTo(entity);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody ScriptDto dto) {
        Script entity = scriptConverter.convertFrom(dto);
        scriptService.add(entity);
    }

    @DeleteMapping(path = "{code}")
    public void remove(@PathVariable String code) {
        scriptService.remove(code);
    }

}
