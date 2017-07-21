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
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@RequestMapping("/")
public class MainPageController extends ExceptionHandlerController {

    @GetMapping(value = "/")
    public ModelAndView getMainPage() {
        return new ModelAndView("index.html");
    }

}
