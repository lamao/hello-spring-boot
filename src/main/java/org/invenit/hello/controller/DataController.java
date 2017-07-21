package org.invenit.hello.controller;

import org.invenit.hello.controller.exception.RestException;
import org.invenit.hello.entity.Data;
import org.invenit.hello.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@RestController
@RequestMapping("/")
public class DataController extends ExceptionHandlerController {

    private static final Logger LOG = LoggerFactory.getLogger(DataController.class);

    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping(value = "/persist", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity persist(@RequestBody Data data) throws RestException {
        try {
            if (data == null) {
                return ResponseEntity.badRequest().body("Empty content");
            }
            dataService.persist(data);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @GetMapping(value = "/getRandomData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<Data> getRandomData() throws RestException {
        try {
            return dataService.getRandomData();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

}
