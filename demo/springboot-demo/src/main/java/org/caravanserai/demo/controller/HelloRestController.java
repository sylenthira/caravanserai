package org.caravanserai.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sylenthira on 2/11/2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloRestController {

    @RequestMapping
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
