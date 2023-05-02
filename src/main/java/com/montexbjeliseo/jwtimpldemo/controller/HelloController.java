package com.montexbjeliseo.jwtimpldemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author montexbjeliseo
 */


@RestController
public class HelloController {
    
    @GetMapping(value = "/hello")
    public ResponseEntity<?> hello(){
        return new ResponseEntity<String>("Hola mundo", HttpStatus.OK);
    }
}
