package org.invenit.hello.controller;

import java.util.Collections;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@RestController
@RequestMapping("/dev/db-manager")
public class DatabaseManagerController {

    private Boolean isLaunched = false;

    @PostMapping("run")
    public void run() {
        System.setProperty("java.awt.headless", "false");
        DatabaseManagerSwing.main(new String[] {"--url", "jdbc:hsqldb:mem:testdb", "--user", "sa",
                "--password", ""});
        isLaunched = true;
    }

    @GetMapping("status")
    public ResponseEntity getStatus() {
        return ResponseEntity.ok(Collections.singletonMap("launched", isLaunched));
    }
}
