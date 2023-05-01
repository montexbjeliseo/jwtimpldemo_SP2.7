package com.montexbjeliseo.jwtimpldemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author monte
 */


@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return new ResponseEntity<String>("Hola mundo", HttpStatus.OK);
    }
}
